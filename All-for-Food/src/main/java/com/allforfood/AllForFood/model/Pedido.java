package com.allforfood.AllForFood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private LocalDateTime data;

    public Long getId() {

        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @ManyToOne()
    private Cliente cliente;

    @OneToMany()
    private List<Produto> produto;

    public  void atualizar(Pedido pedido){
        this.data = pedido.getData();
    }



}
