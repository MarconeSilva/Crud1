package com.marcone.crud1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcone.crud1.entidade.Produto;

public interface RepositorioDeProduto extends JpaRepository<Produto, Long>{

	

}
