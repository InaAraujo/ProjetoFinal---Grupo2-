package com.allforfood.AllForFood.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(length = 200)
    private String nome;

    @NotBlank
    @Email
    @Column(length = 200)
    private String email;


    @NotBlank
    @Column(length = 20)
    private String telefone;
    @NotBlank
    @Column(length = 200)
    private String logradouro;

    @NotBlank
    @Column(length = 200)
    private String bairro;

    @NotBlank
    @Column(length = 10)
    private Integer numero;



    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void atualizar(Cliente cliente){
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.logradouro = cliente.getLogradouro();
        this.bairro = cliente.getBairro();
        this.numero = cliente.getNumero();
    }
}