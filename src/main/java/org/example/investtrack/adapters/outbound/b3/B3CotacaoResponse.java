package org.example.investtrack.adapters.outbound.b3;

import java.math.BigDecimal;
import java.util.List;

public class B3CotacaoResponse {

    private List<BrapiQuoteResult> results;

    public List<BrapiQuoteResult> getResults() {
        return results;
    }

    public void setResults(List<BrapiQuoteResult> results) {
        this.results = results;
    }

    public BrapiQuoteResult firstResult() {
        if (results == null || results.isEmpty()) {
            return null;
        }

        return results.getFirst();
    }

    public static class BrapiQuoteResult {

        private String symbol;
        private BigDecimal regularMarketPrice;
        private String regularMarketTime;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public BigDecimal getRegularMarketPrice() {
            return regularMarketPrice;
        }

        public void setRegularMarketPrice(BigDecimal regularMarketPrice) {
            this.regularMarketPrice = regularMarketPrice;
        }

        public String getRegularMarketTime() {
            return regularMarketTime;
        }

        public void setRegularMarketTime(String regularMarketTime) {
            this.regularMarketTime = regularMarketTime;
        }
    }
}
