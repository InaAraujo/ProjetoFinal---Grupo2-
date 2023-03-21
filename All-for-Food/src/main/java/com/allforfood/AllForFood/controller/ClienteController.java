package com.allforfood.AllForFood.controller;

import com.allforfood.AllForFood.model.Cliente;
import com.allforfood.AllForFood.repository.ClienteRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public Iterable<Cliente> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente mostrarPorId(@PathVariable long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void Cadastrar(@RequestBody Cliente cliente) {
        repository.save(cliente);
    }

    @PutMapping("/{id}")
    private void alterarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Cliente clienteEncontrado = clienteOptional.get();
        clienteEncontrado.atualizar(cliente);

        repository.save(clienteEncontrado);
    }

    @DeleteMapping("/{id}")
    private void deletarCliente(@PathVariable long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(clienteOptional.get());
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
