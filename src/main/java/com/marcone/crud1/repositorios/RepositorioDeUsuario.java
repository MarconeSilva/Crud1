package com.marcone.crud1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcone.crud1.entidade.Usuarios;

public interface RepositorioDeUsuario extends JpaRepository<Usuarios, Long>{

}
