package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture17_thenRunAsync {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	CompletableFuture<Void> futureRun = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando runAsync for thenRun...");
	    Sleep.sleepSeconds(2);
	    LOGGER.info("Terminado runAsync for thenRun!");
	}, executor);	 	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture17_thenRunAsync app = new CompletableFuture17_thenRunAsync();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
					
		futureRun.thenRunAsync(() -> {
		    LOGGER.info("Comenzando thenRun...");
		    Sleep.sleepSeconds(2);
		    LOGGER.info("Terminado thenRun!");
		}, executor);
	}	
		
}
