package com.example.demo.controller;
public class Cliente {
    private String nome;
    private Double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

    // Construtor, Getters e Setters omitidos para brevidade
}

class Transacao {
    private String recebedor;
    private String pagador;
    private Double quantidade;

    // Construtor, Getters e Setters omitidos para brevidade
}