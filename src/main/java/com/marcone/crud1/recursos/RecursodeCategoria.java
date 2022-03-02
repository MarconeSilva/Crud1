package com.marcone.crud1.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud1.entidade.Categoria;
import com.marcone.crud1.servicos.ServicoDeCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursodeCategoria {
	
	@Autowired
	private ServicoDeCategoria servico;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping ( value = "/{id}") 
		public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria categoria = servico.findById(id);	
		return ResponseEntity.ok().body(categoria);	
		
	}


}
