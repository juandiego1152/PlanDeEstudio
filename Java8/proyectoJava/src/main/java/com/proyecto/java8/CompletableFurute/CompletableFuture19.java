package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture19 {
	/*handle: registra un callback para gestionar el resultado o excepción. 
	 Recibe una lambda que tiene dos parámetros, el resultado y la excepción. 
	 Si la excepción no es nula, es que ha habido una excepción. También
	 deber retornar un valor del tipo del futuro que lanzo la excepción.*/
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
		
	CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
	    LOGGER.info("Comenzando supplyAsync with exception...");
	    Sleep(2);
	    LOGGER.info("Terminado supplyAsync with exception!");
	    throw new RuntimeException("Error en el futuro");
	}, executor);
	 
	CompletableFuture<String> handledFuture = futureAsync.handleAsync((s, e) -> {
	    if (e != null) {
	        LOGGER.severe("Resultado con excepción!! "+ e);
	        return "StringPorDefecto";
	    } else {
	        LOGGER.info("Resultado: {}"+ s);
	        return s;
	    }
	}, executor);
	 	
	public void llamarMetodo(){
		handledFuture.whenCompleteAsync((s, e) -> LOGGER.info("Resultado handle: {}"+ s),
		        executor);
	}
	
	public static void main(String[] args) {
		CompletableFuture19 app = new CompletableFuture19();
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
