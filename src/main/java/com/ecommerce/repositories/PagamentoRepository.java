package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
