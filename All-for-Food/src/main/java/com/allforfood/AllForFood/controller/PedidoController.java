package com.allforfood.AllForFood.controller;


import com.allforfood.AllForFood.model.Pedido;
import com.allforfood.AllForFood.repository.PedidoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;


    @GetMapping
    public Iterable<Pedido> list() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido mostrarPorId(@PathVariable long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            return pedidoOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void Cadastrar(@RequestBody Pedido pedido) {
        LocalDateTime.now();
        pedidoRepository.save(pedido);
    }


    @PutMapping("/{id}")
    private void alterarCliente(@PathVariable long id, @RequestBody Pedido pedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pedido pedidoEncontrado = pedidoOptional.get();
        pedidoEncontrado.atualizar(pedido);

        pedidoRepository.save(pedidoEncontrado);
    }


    @DeleteMapping("/{id}")
    private void deletarCliente(@PathVariable long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pedidoRepository.delete(pedidoOptional.get());
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
