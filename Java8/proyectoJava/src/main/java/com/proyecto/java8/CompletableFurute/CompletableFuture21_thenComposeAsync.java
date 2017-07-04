package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.concurrent.CompletableFuture;

public class CompletableFuture21_thenComposeAsync {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando supplyAsync for thenCompose...");
        Sleep.sleepSeconds(2);
        LOGGER.info("Terminado supplyAsync for thenCompose!");
        return "Terminado";
    }, executor);

    CompletableFuture<String> fCompose = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> {
                        LOGGER.info("Comenzando thenCompose...");
                        Sleep.sleepSeconds(2);
                        LOGGER.info("Terminado thenCompose!");
                        return s.concat(" + Terminado thenCompose");
                    }, executor),
                    executor);
    
    
    public void llamarMetodo(){
    	fCompose.whenCompleteAsync((s, e) -> LOGGER.info("Resultado thenCompose: {}"+ s),
                executor);
	}
	
	public static void main(String[] args) {
		CompletableFuture21_thenComposeAsync app = new CompletableFuture21_thenComposeAsync();
		app.llamarMetodo();
	}
		
}
