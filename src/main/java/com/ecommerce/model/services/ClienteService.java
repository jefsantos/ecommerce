package com.ecommerce.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ClienteDTO;
import com.ecommerce.model.Cliente;
import com.ecommerce.model.services.exceptions.DataIntegrityException;
import com.ecommerce.model.services.exceptions.ObjectNotFoundException;
import com.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliRepo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = cliRepo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto nao encontrado!" + id + ",TIPO:" + Cliente.class.getName()));

	}

	public Cliente insert(Cliente obj) {

		obj.setId(null);

		return cliRepo.save(obj);
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return cliRepo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			cliRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma Cliente com Produtos");
		}
	}

	public List<Cliente> findAll() {
		return cliRepo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cliRepo.findAll(pageRequest);

	}

	public Cliente fromDto(ClienteDTO objDto) {
		return new Cliente(
				objDto.getId(), 
				objDto.getNome(), 
				objDto.getEmail(), null, null);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());

	}
}
