package com.allforfood.AllForFood.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private LocalDate data_pedido;

    public Long getId() {
        return id;
    }

    public LocalDate getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }

    @OneToMany(mappedBy = "pedido")
    private List<Cliente> cliente;

    @OneToMany(mappedBy = "pedido" )
    private List<Produto> produto;

    public  void atualizar(Pedido pedido){
        this.data_pedido = pedido.getData_pedido();
    }



}
