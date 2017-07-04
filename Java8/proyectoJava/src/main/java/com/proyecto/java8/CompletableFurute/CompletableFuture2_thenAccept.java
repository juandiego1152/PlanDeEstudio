package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class CompletableFuture2_thenAccept {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	 
	/*thenAccept y thenRun: muy similares al whenComplete, ejecutaran el lambda una vez se 
	complete el futuro. El primero recibe un resultado, y el segundo no. Son equivalentes 
	al supplyAsync y runAsync respectivamente.*/
	
	CompletableFuture<Void> future = completableFuture
	  .thenAccept(s -> System.out.println("Valor de retorno: " + s));	 

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture2_thenAccept app = new CompletableFuture2_thenAccept();
		app.metodo();				
	}
	
	private void metodo(){
		 completableFuture.whenComplete((s, e) -> LOGGER.info("Resultado applyAsync: {}" + s) );
	}
	
		
}


