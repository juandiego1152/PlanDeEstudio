package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.Callable;

public class CHilo implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "Estoy retornando String Callable";
	}

	
}
