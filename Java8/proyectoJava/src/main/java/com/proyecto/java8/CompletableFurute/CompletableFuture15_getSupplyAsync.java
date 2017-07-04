package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture15_getSupplyAsync {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	ExecutorService executor = Executors.newCachedThreadPool();
		
	CompletableFuture<Void> futureRunAsync = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando runAsync...");
	    Sleep.sleepSeconds(3);
	    LOGGER.info("Terminado runAsync!");
	}, executor);
	 
	CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando supplyAsync...");
	    Sleep.sleepSeconds(3);
	    LOGGER.info("Terminado supplyAsync!");
	    return "Terminado";
	}, executor);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture15_getSupplyAsync app = new CompletableFuture15_getSupplyAsync();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
		LOGGER.info("Resultado bloqueando supplyAsync: " + futureSupplyAsync.get());
	}

		 
}
