package com.allforfood.AllForFood.controller;


import com.allforfood.AllForFood.cliente.Cliente;
import com.allforfood.AllForFood.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Cliente")
public class ClienteController {
    //instanciando o repositorio//
    @Autowired
    private ClienteRepository repository;

    @PostMapping
    //Criando uma funcao que vai enviar os dados do cliente para o banco//
    public void Cadastrar(@RequestBody Cliente cliente){
        repository.save(cliente);
    }


}
