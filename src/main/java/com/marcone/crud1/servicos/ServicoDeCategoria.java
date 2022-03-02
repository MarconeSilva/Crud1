package com.marcone.crud1.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud1.entidade.Categoria;
import com.marcone.crud1.repositorios.RepositorioDeCategoria;

@Service
public class ServicoDeCategoria {
	
	@Autowired
	private RepositorioDeCategoria repositorio;
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		return categoria.get();
	}
	
}
