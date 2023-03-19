package com.allforfood.AllForFood.controller;
import com.allforfood.AllForFood.model.Cliente;
import com.allforfood.AllForFood.model.Produto;
import com.allforfood.AllForFood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public Iterable<Produto> list() {
        return repository.findAll();

    }
    @GetMapping("/{id}")
    public Produto mostrarPorId(@PathVariable long id) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void Cadastrar(@RequestBody Produto produto){
        repository.save(produto);

    }

    @PutMapping("/{id}")
    private void alterarProduto(@PathVariable long id, @RequestBody Produto produto) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Produto produtoEncontrado = produtoOptional.get();
        produtoEncontrado.atualizar(produto);

        repository.save(produtoEncontrado);
    }

    @DeleteMapping("/{id}")
    private void deletarProduto(@PathVariable long id) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(produtoOptional.get());
    }


}