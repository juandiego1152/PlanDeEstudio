package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture25 {

	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	  // acceptEither
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando future1 con acceptEither...");
        Sleep.sleepSeconds(3);
        LOGGER.info("Terminado future1 con acceptEither!");
        return "Segundo";
    }, executor);

    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando future2 con acceptEither...");
        Sleep.sleepSeconds(1);
        LOGGER.info("Terminado future2 con acceptEither!");
        return "Primero";
    }, executor);

    public void llamarMetodo(){
    	future1.acceptEitherAsync(future2, (s) ->
        LOGGER.info("En el acceptEither, recibido el primer resultado: {}"+ s)
        	, executor);
	}
		
	public static void main(String[] args) {
		CompletableFuture25 app = new CompletableFuture25();
		app.llamarMetodo();
	}
	
    
}
