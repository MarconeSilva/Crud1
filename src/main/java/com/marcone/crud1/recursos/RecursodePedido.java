package com.marcone.crud1.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcone.crud1.entidade.Pedido;
import com.marcone.crud1.servicos.ServicoDePedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursodePedido {
	
	@Autowired
	private ServicoDePedido servico;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping ( value = "/{id}") 
		public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido pedido = servico.findById(id);	
		return ResponseEntity.ok().body(pedido);
		
	}

}
