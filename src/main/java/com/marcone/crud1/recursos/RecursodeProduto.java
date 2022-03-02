package com.marcone.crud1.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud1.entidade.Produto;
import com.marcone.crud1.servicos.ServicoDeProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursodeProduto {
	
	@Autowired
	private ServicoDeProduto servico;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping ( value = "/{id}") 
		public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto produto = servico.findById(id);	
		return ResponseEntity.ok().body(produto);	
		
	}


}
