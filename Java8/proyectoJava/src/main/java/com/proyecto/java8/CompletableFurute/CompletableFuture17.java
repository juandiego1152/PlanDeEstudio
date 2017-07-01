package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture17 {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	CompletableFuture<Void> futureRun = CompletableFuture.runAsync(() -> {
	    LOGGER.info("Comenzando runAsync for thenRun...");
	    Sleep(2);
	    LOGGER.info("Terminado runAsync for thenRun!");
	}, executor);	 	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {	        
		CompletableFuture17 app = new CompletableFuture17();
		app.llamarMetodos();		
    } 
	
	public void llamarMetodos() throws InterruptedException, ExecutionException{				
					
		futureRun.thenRunAsync(() -> {
		    LOGGER.info("Comenzando thenRun...");
		    Sleep(2);
		    LOGGER.info("Terminado thenRun!");
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
