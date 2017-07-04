package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture16_thenAcceptAsync {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando supplyAsync for thenAccept...");
	    Sleep(2);
	    LOGGER.info("Terminado supplyAsync for thenAccept!");
	    return "Terminado";
	}, executor); 	 
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture16_thenAcceptAsync app = new CompletableFuture16_thenAcceptAsync();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{			
		
		futureAsync.thenAcceptAsync(s -> { 
		    LOGGER.info("Comenzando thenAccept...");
		    Sleep(2);
		    LOGGER.info("Terminado thenAccept!");
		    LOGGER.info("Resultado: {}" + s);
		}, executor);		
	}
	
	private void Sleep(int i) {
		try{
			//Thread.sleep(i * 1000);
			int finalx = i * 1000;
			int x = 0;
			while (x < finalx) {
				System.out.println(x);
				Thread.sleep(1000);
				x = x + 1000;				 
			}		
		}catch(InterruptedException e){	}			
	}		
}
