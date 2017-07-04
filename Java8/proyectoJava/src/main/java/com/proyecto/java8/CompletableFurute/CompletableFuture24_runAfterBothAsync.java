package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture24_runAfterBothAsync {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/*thenAcceptBoth y runAfterBoth: Muy similares al ‘thenCombine’, excepto que 
	no generan un nuevo futuro, simplemente ejecutan la lambda cuando los dos 
	futuros terminen. Es como un ‘whenComplete‘ pero esperando dos futuros*/
	
	
	CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando future1 for runAfterBoth...");
	    Sleep(2);
	    LOGGER.info("Terminado future1 for runAfterBoth!");
	}, executor);
	 
	CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando future2 for runAfterBoth...");
	    Sleep(1);
	    LOGGER.info("Terminado future2 for runAfterBoth!");
	}, executor);
	 	 	
	
	public void llamarMetodo(){
		future1.runAfterBothAsync(future2, () -> LOGGER.info("En el runAfterBoth, futuros terminados.")
		        , executor);
	}
		
	public static void main(String[] args) {
		CompletableFuture24_runAfterBothAsync app = new CompletableFuture24_runAfterBothAsync();
		app.llamarMetodo();
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
