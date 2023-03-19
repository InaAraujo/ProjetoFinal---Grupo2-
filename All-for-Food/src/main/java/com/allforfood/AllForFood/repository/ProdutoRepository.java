package com.allforfood.AllForFood.repository;

import com.allforfood.AllForFood.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}