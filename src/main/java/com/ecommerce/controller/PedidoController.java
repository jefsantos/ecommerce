package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Pedido;
import com.ecommerce.model.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
	
    @Autowired
	private PedidoService pedService;

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = pedService.find(id);
		
		return ResponseEntity.ok().body(obj);
		
		
		

	}

}
