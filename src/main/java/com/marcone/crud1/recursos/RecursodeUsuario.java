package com.marcone.crud1.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping 
	public ResponseEntity<Usuarios> cadastrar(@RequestBody Usuarios usuario){
		usuario = servico.cadastrar(usuario);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> deletar (@PathVariable Long id){
		servico.deletar(id);
		return ResponseEntity.noContent().build();				
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<Usuarios> atualizar(@PathVariable Long id, @RequestBody Usuarios usuario ) {
		usuario = servico.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}

}
