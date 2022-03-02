package com.marcone.crud1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcone.crud1.entidade.Pedido;

public interface RepositorioDePedido extends JpaRepository<Pedido, Long>{

}
