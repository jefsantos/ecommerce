package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
