package org.example.investtrack.Domain.model.carteiras;

import java.time.LocalDateTime;
import java.util.UUID;

public class Carteiras {

    private String nome;
    private String descricao;
    private UUID id_carteira;
    private UUID id_cliente;
    private LocalDateTime data_criacao;

    public Carteiras() {}

    public Carteiras(String nome,String descricao ,UUID id_carteira, UUID id_cliente, LocalDateTime data_criacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.id_carteira = id_carteira;
        this.id_cliente = id_cliente;
        this.data_criacao = data_criacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UUID getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(UUID id_carteira) {
        this.id_carteira = id_carteira;
    }

    public UUID getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(UUID id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }
}