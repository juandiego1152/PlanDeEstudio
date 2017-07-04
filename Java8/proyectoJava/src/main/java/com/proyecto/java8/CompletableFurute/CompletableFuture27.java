package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture27 {

	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ExecutorService executor = Executors.newCachedThreadPool();
	 
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando future1 for allOf...");
        Sleep.sleepSeconds(2);
        LOGGER.info("Terminado future1 for allOf!");
        return "Terminado future1";
    }, executor);

    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando future2 for allOf...");
        Sleep.sleepSeconds(1);
        LOGGER.info("Terminado future2 for allOf!");
        return "Terminado future2";
    }, executor);

    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando future3 for allOf...");
        Sleep.sleepSeconds(10);
        LOGGER.info("Terminado future3 for allOf!");
        return "Terminado future3";
    }, executor);

   
    
    public void llamarMetodo(){ 
    	 CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3);
    	    all.whenCompleteAsync((s, e) -> LOGGER.info("Resultado all: {}"+ s), executor);
	}
		
	public static void main(String[] args) {
		CompletableFuture27 app = new CompletableFuture27();
		app.llamarMetodo();
	}
}
