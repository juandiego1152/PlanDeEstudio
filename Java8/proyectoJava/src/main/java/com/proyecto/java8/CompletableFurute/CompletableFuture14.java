package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.*;


public class CompletableFuture14 {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture14 app = new CompletableFuture14();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
		futureApply.whenCompleteAsync((s, e) -> LOGGER.info("Resultado applyAsync: {}" + s) );
	}
	
	 
	CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {	  
	 	LOGGER.log(Level.INFO, "Comenzando supplyAsync for thenApply...");
	    //Sleep.sleepSeconds(2);
	    Sleep(2);		  
	    LOGGER.log(Level.INFO, "Terminado supplyAsync for thenApply!");
	    return "Terminado";
	}, executor);
	 
	CompletableFuture<String> futureApply = futureAsync.thenApplyAsync(s -> {
		//System.out.println("Comenzando applyAsync...");
	    LOGGER.info("Comenzando applyAsync...");
	    //Sleep.sleepSeconds(2);
	    Sleep(2);
	    LOGGER.info("Terminado applyAsync!");
	    return s.toUpperCase();
	}, executor);
	
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
