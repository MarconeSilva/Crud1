package com.marcone.crud1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcone.crud1.entidade.Categoria;

public interface RepositorioDeCategoria extends JpaRepository<Categoria, Long>{

}
