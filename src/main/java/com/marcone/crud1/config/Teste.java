package com.marcone.crud1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcone.crud1.entidade.Usuarios;
import com.marcone.crud1.repositorios.RepositorioDeUsuario;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner{
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		Usuarios u1 = new Usuarios(null, "marcone", "marcone@gmail.com", "988849634", "12345");
		Usuarios u2 = new Usuarios(null, "nayma	", "nayma@gmail.com", "988849634", "12345");
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
	}

}
