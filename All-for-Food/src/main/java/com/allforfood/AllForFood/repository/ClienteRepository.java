package com.allforfood.AllForFood.repository;

import com.allforfood.AllForFood.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
