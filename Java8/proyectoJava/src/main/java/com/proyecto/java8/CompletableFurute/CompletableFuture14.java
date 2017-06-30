package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.*;

public class CompletableFuture14 {

	private final static Logger LOGGER = Logger.getLogger("Mylogger");
	//private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	//private final static Logger LOGGER = Logger.getLogger(CompletableFuture14.class.getName());
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
              
        LOGGER.severe("Severe");
        LOGGER.info("Info");
        LOGGER.warning("Warning");
        LOGGER.log(Level.SEVERE, "Severe 2");
        LOGGER.log(Level.INFO, "Info 2");
        LOGGER.log(Level.WARNING, "Warning 2");
        //LOGGER.config("Config");
        LOGGER.fine("Fine");
        LOGGER.finer("Finer");
		CompletableFuture14 app = new CompletableFuture14();
		app.llamarMetodos();
		
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
				 LOGGER.fine("Fine");
			        LOGGER.finer("Finer");
			}		
		}catch(InterruptedException e){	}	
		
	}
	 
	 CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
		    //LOGGER.info("Comenzando supplyAsync for thenApply...");
		 	//System.out.println("Algo nuevo");
		 	LOGGER.log(Level.INFO, "Comenzando supplyAsync for thenApply...");
		    //Sleep.sleepSeconds(2);
		    Sleep(2);
		    //LOGGER.info("Terminado supplyAsync for thenApply!");
		    LOGGER.log(Level.INFO, "Terminado supplyAsync for thenApply!");
		    return "Terminado";
		}, executor);
		 
		CompletableFuture<String> futureApply = futureAsync.thenApplyAsync(s -> {
			//System.out.println("Otra impresion");
		    LOGGER.info("Comenzando applyAsync...");
		    //Sleep.sleepSeconds(2);
		    Sleep(2);
		    LOGGER.info("Terminado applyAsync!");
		    return s.toUpperCase();
		}, executor);
		 
		public void llamarMetodos(){
			//futureApply.whenCompleteAsync((s, e) -> LOGGER.info("Resultado applyAsync: {}", s));}
			//futureApply.whenCompleteAsync((s, e) -> LOGGER.log(Level.WARNING ,"Resultado applyAsync: {}"+ s));		
			futureApply.whenCompleteAsync((s, e) -> LOGGER.info("Resultado applyAsync: {}" + s) );
			//futureApply.whenCompleteAsync((s, e) ->  System.out.println("Resultado applyAsync: {}" + s) );
		}
	
}