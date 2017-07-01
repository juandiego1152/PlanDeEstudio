package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture15 {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	ExecutorService executor = Executors.newCachedThreadPool();
		
	CompletableFuture<Void> futureRunAsync = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando runAsync...");
	    Sleep(3);
	    LOGGER.info("Terminado runAsync!");
	}, executor);
	 
	CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando supplyAsync...");
	    Sleep(3);
	    LOGGER.info("Terminado supplyAsync!");
	    return "Terminado";
	}, executor);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture15 app = new CompletableFuture15();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
		LOGGER.info("Resultado bloqueando supplyAsync: " + futureSupplyAsync.get());
	}
	
	 private void Sleep(int i) {
		try{
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
