package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.*;


public class CompletableFuture14_thenApplyAsync {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture14_thenApplyAsync app = new CompletableFuture14_thenApplyAsync();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
		futureApply.whenCompleteAsync((s, e) -> LOGGER.info("Resultado applyAsync: {}" + s) );
	}
		 
	CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {	  
	 	LOGGER.log(Level.INFO, "Comenzando supplyAsync for thenApply...");
	    Sleep.sleepSeconds(2);
	    	  
	    LOGGER.log(Level.INFO, "Terminado supplyAsync for thenApply!");
	    return "Terminado";
	}, executor);
	 
	CompletableFuture<String> futureApply = futureAsync.thenApplyAsync(s -> {
		//System.out.println("Comenzando applyAsync...");
	    LOGGER.info("Comenzando applyAsync...");
	    Sleep.sleepSeconds(2);	
	    LOGGER.info("Terminado applyAsync!");
	    return s.toUpperCase();
	}, executor);
				
}
