package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
