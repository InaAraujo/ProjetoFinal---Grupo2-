package com.allforfood.AllForFood.model;

import jakarta.persistence.*;

@Entity
public class Produto {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @Column(length = 200, nullable = false)
     private String nomeProduto;
     @Column(length = 200, nullable = false)
     private String descricao;
     @Column(length = 20, nullable = false)
     private String codigoProduto;
     @Column(length = 10, nullable = false)
     private String bordaRecheada;
     @Column(length = 15, nullable = false)
     private String valor;

     @ManyToOne
     @JoinColumn(name = "pedido_id", nullable = false)
     private Pedido pedido;


     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getNomeProduto() {
          return nomeProduto;
     }

     public void setNomeProduto(String nomeProduto) {
          this.nomeProduto = nomeProduto;
     }

     public String getDescricao() {
          return descricao;
     }

     public void setDescricao(String descricao) {
          this.descricao = descricao;
     }

     public String getCodigoProduto() {
          return codigoProduto;
     }

     public void setCodigoProduto(String codigoProduto) {
          this.codigoProduto = codigoProduto;
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

     public void atualizar(Produto produto){
          this.nomeProduto = produto.getNomeProduto();
          this.descricao = produto.getDescricao();
          this.codigoProduto = produto.getCodigoProduto();
          this.bordaRecheada = produto.getBordaRecheada();
          this.valor = produto.getValor();

     }

}