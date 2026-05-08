package org.example.investtrack.Domain.entity.cliente;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDateTime data_cadastro;

    public Cliente() {}

    public Cliente(UUID id, String nome, String cpf, String email, LocalDateTime data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_cadastro = data_cadastro;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}