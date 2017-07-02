package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.concurrent.CompletableFuture;

public class CompletableFuture21 {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        LOGGER.info("Comenzando supplyAsync for thenCompose...");
        Sleep(2);
        LOGGER.info("Terminado supplyAsync for thenCompose!");
        return "Terminado";
    }, executor);

    CompletableFuture<String> fCompose = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> {
                        LOGGER.info("Comenzando thenCompose...");
                        Sleep(2);
                        LOGGER.info("Terminado thenCompose!");
                        return s.concat(" + Terminado other");
                    }, executor),
                    executor);
    
    
    public void llamarMetodo(){
    	fCompose.whenCompleteAsync((s, e) -> LOGGER.info("Resultado thenCompose: {}"+ s),
                executor);
	}
	
	public static void main(String[] args) {
		CompletableFuture21 app = new CompletableFuture21();
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
