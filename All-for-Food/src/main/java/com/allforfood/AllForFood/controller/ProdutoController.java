package com.allforfood.AllForFood.controller;

import com.allforfood.AllForFood.model.Produto;
import com.allforfood.AllForFood.repository.ProdutoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    public Random random = new Random();
    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping
    public Iterable<Produto> list() {
        return repository.findAll();

    }
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/{id}")
    public Produto mostrarPorId(@PathVariable long id) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void Cadastrar(@RequestBody Produto produto){
        produto.setCodigo(String.valueOf(random.nextInt(1000,9999)));
        produto.setValor(String.valueOf(random.nextInt(30,50)));
        repository.save(produto);
    }
    @CrossOrigin(origins = "http://localhost:8100")
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
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping("/{id}")
    private void deletarProduto(@PathVariable long id) {
        Optional<Produto> produtoOptional = repository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(produtoOptional.get());
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> tratar(ConstraintViolationException exception) {
        List<String> erros = new ArrayList<>();

        for(ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String erro = String.format(
                    "%s %s",
                    violation.getPropertyPath().toString(),
                    violation.getMessage()
            );

            erros.add(erro);
        }

        return erros;
    }


}