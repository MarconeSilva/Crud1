package com.marcone.crud1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcone.crud1.entidade.Categoria;
import com.marcone.crud1.entidade.ItemDePedido;
import com.marcone.crud1.entidade.Pagamento;
import com.marcone.crud1.entidade.Pedido;
import com.marcone.crud1.entidade.Produto;
import com.marcone.crud1.entidade.Usuarios;
import com.marcone.crud1.entidade.enums.StatusDoPedido;
import com.marcone.crud1.repositorios.RepositorioDeCategoria;
import com.marcone.crud1.repositorios.RepositorioDeItemDePedido;
import com.marcone.crud1.repositorios.RepositorioDePedido;
import com.marcone.crud1.repositorios.RepositorioDeProduto;
import com.marcone.crud1.repositorios.RepositorioDeUsuario;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner{
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;
	
	@Autowired
	private RepositorioDePedido repositorioDePedido;
	
	@Autowired
	private RepositorioDeCategoria repositorioDeCategoria;
	
	@Autowired
	private RepositorioDeProduto repositorioDeProduto;
	
	@Autowired
	private RepositorioDeItemDePedido repositorioDeItemDePedido;

	@Override
	public void run(String... args) throws Exception {
		
		Usuarios u1 = new Usuarios(null, "marcone", "marcone@gmail.com", "988849634", "12345");
		Usuarios u2 = new Usuarios(null, "nayma", "nayma@gmail.com", "988849634", "12345");
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
		
		Pedido ped1 = new Pedido(null, Instant.parse("2022-02-26T19:11:07Z"), StatusDoPedido.PAGO, u1);
		Pedido ped2 = new Pedido(null, Instant.parse("2022-02-23T19:18:07Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido ped3 = new Pedido(null, Instant.parse("2022-02-20T19:31:07Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO, u1);
		
		repositorioDePedido.saveAll(Arrays.asList(ped1, ped2, ped3));
		
		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		repositorioDeCategoria.saveAll(Arrays.asList(c1, c2, c3));
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		p1.getCategorias().add(c2);
		p2.getCategorias().add(c1);
		p2.getCategorias().add(c3);
		p3.getCategorias().add(c3);
		p4.getCategorias().add(c3);
		p5.getCategorias().add(c2);
		
		repositorioDeProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		ItemDePedido ip1 = new ItemDePedido(ped1, p1, 2, p1.getpreco());
		ItemDePedido ip2 = new ItemDePedido(ped1, p3, 1, p3.getpreco());
		ItemDePedido ip3 = new ItemDePedido(ped2, p3, 2, p3.getpreco());
		ItemDePedido ip4 = new ItemDePedido(ped3, p5, 2, p5.getpreco());
		
		
		repositorioDeItemDePedido.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2022-02-26T21:11:07Z"), ped1);
		ped1.setPagamento(pag1);
		
		repositorioDePedido.save(ped1);
	}
	

}
