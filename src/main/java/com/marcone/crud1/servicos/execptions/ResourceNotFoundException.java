package com.marcone.crud1.servicos.execptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException (Object id) {
		super("Recurso nao Encontrado. id " + id);
	}
	

}
