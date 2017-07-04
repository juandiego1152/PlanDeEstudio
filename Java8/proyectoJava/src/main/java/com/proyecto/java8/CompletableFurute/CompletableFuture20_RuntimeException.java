package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CompletableFuture20_RuntimeException {
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	 CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
	        LOGGER.info("Comenzando supplyAsync con exception...");
	        Sleep(2);
	        LOGGER.info("Terminado supplyAsync con exception!");
	        throw new RuntimeException("Error en el futuro");
	    }, executor);	   
	    
	    
	    public void llamarMetodo(){
	    	futureAsync.whenCompleteAsync((s, e) -> {
		        if (e != null) {
		            LOGGER.warning("Resultado con excepción!!"+ e);
		        } else {
		            LOGGER.info("Resultado applyAsync: {}"+ s);
		        }
		    }, executor);
		}
		
		public static void main(String[] args) {
			CompletableFuture20_RuntimeException app = new CompletableFuture20_RuntimeException();
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
