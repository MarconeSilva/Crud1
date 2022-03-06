package com.marcone.crud1.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcone.crud1.entidade.Usuarios;
import com.marcone.crud1.repositorios.RepositorioDeUsuario;
import com.marcone.crud1.servicos.execptions.DatabaseException;
import com.marcone.crud1.servicos.execptions.ResourceNotFoundException;

@Service
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuario repositorio;
	
	public List<Usuarios> findAll(){
		return repositorio.findAll();
	}
	
	public Usuarios findById(Long id) {
		Optional<Usuarios> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuarios cadastrar(Usuarios usuario) {
		return repositorio.save(usuario);
	}
	
	
	public Usuarios atualizar(Long id, Usuarios usuario) {
		try {
		Usuarios usuario1 = repositorio.getById(id);
		atualizarDados(usuario1, usuario);
		return repositorio.save(usuario1);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
				
	}
	
	public void deletar(Long id) {
		try {
		repositorio.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch ( DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	private void atualizarDados(Usuarios usuario1, Usuarios usuario) {
		usuario1.setNome(usuario.getNome());
		usuario1.setEmail(usuario.getEmail());
		usuario1.setTelefone(usuario.getTelefone());
		
	}

}
