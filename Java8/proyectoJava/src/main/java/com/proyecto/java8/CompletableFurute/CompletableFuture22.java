package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;


public class CompletableFuture22 {

	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando future1 for thenCombine...");
	    Sleep(2);
	    LOGGER.info("Terminado future1 for thenCombine!");
	    return "Terminado";
	}, executor);
	 
	CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando future2 for thenCombine...");
	    Sleep(1);
	    LOGGER.info("Terminado future2 for thenCombine!");
	    return "Terminado other";
	}, executor);
	 
	CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando future3 for thenCombine...");
	    Sleep(1);
	    LOGGER.info("Terminado future3 for thenCombine!");
	    return "Terminado EL TERCERO";
	}, executor);
	
	CompletableFuture<String> fCombine =
	        future1.thenCombineAsync(future2, (s1, s2) -> {
	            LOGGER.info("En el thenCombine, recibidos results: {}, {}"+ s1+ s2);
	            return s1 + s2;
	        }, executor);
	 
	CompletableFuture<String> fcombine2 = fCombine.thenCombineAsync(future3, (s1, s2) -> {
		return s1 + s2;
		});

	public void llamarMetodo(){
	 fcombine2.whenCompleteAsync((s, e) -> LOGGER.info("Resultado thenCombine: {}" +s),
		        executor);
	}
	
	public static void main(String[] args) {
		CompletableFuture22 app = new CompletableFuture22();
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
