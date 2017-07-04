package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture26 {

	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
    CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
        LOGGER.info("Comenzando future1 con runAfterEither...");
        Sleep.sleepSeconds(3);
        LOGGER.info("Terminado future1 con runAfterEither!");
    }, executor);

    CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
        LOGGER.info("Comenzando future2 con runAfterEither...");
        Sleep.sleepSeconds(1);
        LOGGER.info("Terminado future2 con runAfterEither!");
    }, executor);
    
    
    public void llamarMetodo(){ 
    	future1.runAfterEitherAsync(future2, () -> LOGGER.info("En el runAfterEither, primero terminado.")
                , executor);
	}
		
	public static void main(String[] args) {
		CompletableFuture26 app = new CompletableFuture26();
		app.llamarMetodo();
	}
}
