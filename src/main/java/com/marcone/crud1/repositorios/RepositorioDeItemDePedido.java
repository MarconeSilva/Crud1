package com.marcone.crud1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcone.crud1.entidade.ItemDePedido;

public interface RepositorioDeItemDePedido extends JpaRepository<ItemDePedido, Long>{

}
