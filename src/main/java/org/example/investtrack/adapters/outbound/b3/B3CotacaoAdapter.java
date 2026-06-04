package org.example.investtrack.adapters.outbound.b3;

import org.example.investtrack.Domain.model.cotacoes.Cotacao;
import org.example.investtrack.Domain.port.out.CotacaoPort;
import org.example.investtrack.config.B3ApiProperties;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Locale;

@Component
public class B3CotacaoAdapter implements CotacaoPort {

    private static final String CACHE_KEY_PREFIX = "cotacao:";
    private static final String LAST_KNOWN_KEY_PREFIX = "cotacao:last:";

    private final WebClient b3WebClient;
    private final B3ApiProperties properties;
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    private final ReactiveCircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public B3CotacaoAdapter(
            WebClient b3WebClient,
            B3ApiProperties properties,
            StringRedisTemplate redisTemplate,
            ObjectMapper objectMapper,
            ReactiveCircuitBreakerFactory<?, ?> circuitBreakerFactory
    ) {
        this.b3WebClient = b3WebClient;
        this.properties = properties;
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    public Mono<Cotacao> buscarCotacao(String ticker) {
        String normalizedTicker = ticker.toUpperCase(Locale.ROOT);

        return buscarNoCache(cacheKey(normalizedTicker))
                .switchIfEmpty(
                        circuitBreakerFactory.create("b3-cotacao")
                                .run(buscarNaB3(normalizedTicker).flatMap(this::salvarNoCache),
                                        throwable -> buscarNoCache(lastKnownKey(normalizedTicker)))
                );
    }

    private Mono<Cotacao> buscarNaB3(String ticker) {
        return b3WebClient.get()
                .uri(properties.getQuotePath(), ticker)
                .headers(headers -> {
                    if (properties.getToken() != null && !properties.getToken().isBlank()) {
                        headers.setBearerAuth(properties.getToken());
                    }
                })
                .retrieve()
                .bodyToMono(B3CotacaoResponse.class)
                .flatMap(response -> {
                    B3CotacaoResponse.BrapiQuoteResult result = response.firstResult();

                    if (result == null || result.getRegularMarketPrice() == null) {
                        return Mono.empty();
                    }

                    return Mono.just(new Cotacao(
                            result.getSymbol() == null ? ticker : result.getSymbol().toUpperCase(Locale.ROOT),
                            result.getRegularMarketPrice(),
                            parseDataHora(result.getRegularMarketTime())
                    ));
                });
    }

    private LocalDateTime parseDataHora(String regularMarketTime) {
        if (regularMarketTime == null || regularMarketTime.isBlank()) {
            return LocalDateTime.now();
        }

        try {
            return OffsetDateTime.parse(regularMarketTime).toLocalDateTime();
        } catch (RuntimeException exception) {
            return LocalDateTime.now();
        }
    }

    private Mono<Cotacao> salvarNoCache(Cotacao cotacao) {
        return Mono.fromCallable(() -> {
                    String payload = objectMapper.writeValueAsString(cotacao);
                    redisTemplate.opsForValue().set(
                            cacheKey(cotacao.getTicker()),
                            payload,
                            Duration.ofMinutes(properties.getCacheTtlMinutes())
                    );
                    redisTemplate.opsForValue().set(lastKnownKey(cotacao.getTicker()), payload);
                    return cotacao;
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    private Mono<Cotacao> buscarNoCache(String key) {
        return Mono.fromCallable(() -> redisTemplate.opsForValue().get(key))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(payload -> {
                    if (payload == null) {
                        return Mono.empty();
                    }

                    try {
                        return Mono.just(objectMapper.readValue(payload, Cotacao.class));
                    } catch (JacksonException exception) {
                        return Mono.empty();
                    }
                });
    }

    private String cacheKey(String ticker) {
        return CACHE_KEY_PREFIX + ticker.toUpperCase(Locale.ROOT);
    }

    private String lastKnownKey(String ticker) {
        return LAST_KNOWN_KEY_PREFIX + ticker.toUpperCase(Locale.ROOT);
    }
}
