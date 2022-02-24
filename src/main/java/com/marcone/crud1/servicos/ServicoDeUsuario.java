package com.marcone.crud1.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcone.crud1.entidade.Usuarios;
import com.marcone.crud1.repositorios.RepositorioDeUsuario;

@Service
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuario repositorio;
	
	public List<Usuarios> findAll(){
		return repositorio.findAll();
	}
	
	public Usuarios findById(Long id) {
		Optional<Usuarios> usuario = repositorio.findById(id);
		return usuario.get();
	}
	
}
