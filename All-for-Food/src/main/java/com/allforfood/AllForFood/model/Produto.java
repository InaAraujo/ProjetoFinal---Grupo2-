package com.allforfood.AllForFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(length = 200)
    private String nome;
    @NotBlank
    @Column(length = 200)
    private String descricao;
    @NotBlank
    private String codigo;
    @NotBlank
    @Column(length = 10)
    private String bordaRecheada;
    @NotBlank
    private String valor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBordaRecheada() {
        return bordaRecheada;
    }

    public void setBordaRecheada(String bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;

    }

    public void atualizar(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.codigo = produto.getCodigo();
        this.bordaRecheada = produto.getBordaRecheada();
        this.valor = produto.getValor();

    }

}