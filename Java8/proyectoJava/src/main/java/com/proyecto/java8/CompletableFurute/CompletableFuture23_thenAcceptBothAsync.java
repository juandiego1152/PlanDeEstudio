package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture23_thenAcceptBothAsync {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	/*thenAcceptBoth y runAfterBoth: Muy similares al ‘thenCombine’, excepto que 
	no generan un nuevo futuro, simplemente ejecutan la lambda cuando los dos 
	futuros terminen. Es como un ‘whenComplete‘ pero esperando dos futuros*/
	
	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando future1 for thenAcceptBoth...");
	    Sleep(2);
	    LOGGER.info("Terminado future1 for thenAcceptBoth!");
	    return "Terminado 1 ";
	}, executor);
	 
	CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando future2 for thenAcceptBoth...");
	    Sleep(1);
	    LOGGER.info("Terminado future2 for thenAcceptBoth!");
	    return "Terminado 2";
	}, executor);
	 
	
	
	public void llamarMetodo(){
		future1.thenAcceptBothAsync(future2, (s1, s2) ->
        LOGGER.info("En el thenAcceptBoth, recibidos results: {}, {}"+ s1+ s2)
    	, executor);
		}
		
		public static void main(String[] args) {
			CompletableFuture23_thenAcceptBothAsync app = new CompletableFuture23_thenAcceptBothAsync();
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
