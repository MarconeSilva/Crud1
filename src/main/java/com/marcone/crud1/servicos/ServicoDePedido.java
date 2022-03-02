package com.marcone.crud1.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud1.entidade.Pedido;
import com.marcone.crud1.repositorios.RepositorioDePedido;

@Service
public class ServicoDePedido {
	
	@Autowired
	private RepositorioDePedido repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		return pedido.get();
	}
	
}
