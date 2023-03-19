package com.allforfood.AllForFood.model;


import jakarta.persistence.*;

//Criado a tabela clientes//

@Entity
public class Cliente {

    //determinando id//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 200, nullable = false)
    private String logradouro;
    @Column(length = 200, nullable = false)
    private String bairro;
    @Column(length = 10, nullable = false)
    private Integer numero;

    //Dententor da Chave estrangeira
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

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


    //Contrutor que dara acesso ao dados do cliente e coloca os valores//
    public void atualizar(Cliente cliente){
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.logradouro = cliente.getLogradouro();
        this.bairro = cliente.getBairro();
        this.numero = cliente.getNumero();
    }
}