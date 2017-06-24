package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFuture1 {
	
	CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
		() -> {
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){	}					
			return 10;				
		}
	);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture1 completable = new CompletableFuture1();
		completable.mensaje() ;		
	}
	
	
	public void mensaje(){
		try {
			int count = futureCount.get();
			System.out.println("contador: "+ count);
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}	

}
