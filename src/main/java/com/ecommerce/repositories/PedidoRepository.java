package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
