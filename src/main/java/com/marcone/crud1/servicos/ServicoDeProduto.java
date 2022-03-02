package com.marcone.crud1.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud1.entidade.Produto;
import com.marcone.crud1.repositorios.RepositorioDeProduto;

@Service
public class ServicoDeProduto {
	
	@Autowired
	private RepositorioDeProduto repositorio;
	
	public List<Produto> findAll(){
		return repositorio.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		return produto.get();
	}
	
}
