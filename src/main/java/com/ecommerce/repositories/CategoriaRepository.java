package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
