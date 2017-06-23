package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;



public class CompletableFuture1 {
	
	public static void main(String[] args) {
		
	}
		
		
	public CompletableFuture<String> creacion(){
		
		CompletableFuture<String> future = new CompletableFuture<>();
		CompletableFuture<String> future2 = CompletableFuture.completedFuture("Prueba");
		
		future.complete("Completado");
		
		//CompletableFuture<Void> future3 = CompletableFuture.runAsync((){	}
		return future;
	}
				
	
}


