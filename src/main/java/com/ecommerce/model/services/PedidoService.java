package com.ecommerce.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Pedido;
import com.ecommerce.model.services.exceptions.ObjectNotFoundException;
import com.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedRepo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedRepo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto nao encontrado!" + id + ",TIPO:" + Pedido.class.getName()));

	}

}
