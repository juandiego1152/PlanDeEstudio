package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class CompletableFuture4_complete {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = calculateAsync();		
		String result = completableFuture.get();
		assertEquals("Hello", result);
	}			
	
	public Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete("Hello");
	        return null;
	    });
	    return completableFuture;	    	  
	}
	
	public Future<String> calculateAsync2(){		
		  CompletableFuture<String> resultado = CompletableFuture.supplyAsync(() -> {		  
						try {
							Thread.sleep(2000);
						} catch (Exception e) {	}
						return "Hello";
				  });
		return resultado;	
	}	
	   
}
