package com.ecommerce.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Categoria;
import com.ecommerce.repositories.CategoriaRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = catRepo.findById(id);
		
		return obj.orElse(null);
		
	}
	

}
