package com.marcone.crud1.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud1.entidade.Usuarios;
import com.marcone.crud1.servicos.ServicoDeUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursodeUsuario {
	
	@Autowired
	private ServicoDeUsuario servico;
	
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll(){
		List<Usuarios> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping ( value = "/{id}") 
		public ResponseEntity<Usuarios> findById(@PathVariable Long id){
		Usuarios usuario = servico.findById(id);	
		return ResponseEntity.ok().body(usuario);
		
	}

}
