package com.ecommerce.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.model.Categoria;
import com.ecommerce.model.services.exceptions.DataIntegrityException;
import com.ecommerce.model.services.exceptions.ObjectNotFoundException;
import com.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = catRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado!" + id + ",TIPO:" + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {

		obj.setId(null);

		return catRepo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());

		return catRepo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			catRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma Categoria com Produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return catRepo.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , orderBy);
 return catRepo.findAll(pageRequest);
	
	}
	
	public Categoria fromDto (CategoriaDTO objDto)
	{
		return new Categoria(objDto.getId(), objDto.getNome());
	}
				
				
}
