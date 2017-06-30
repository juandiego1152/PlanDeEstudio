package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableFuture11 {

	@Test
	public void test() {
	
	}


	@Test
	public void test_accept_either_async_nested_finishes_first() throws Exception {
	List<String> results = new ArrayList<String>();
		
	 CompletableFuture<String> callingCompletable = CompletableFuture.supplyAsync(tareaSimulada("calling"));
	 CompletableFuture<String> nestedCompletable = CompletableFuture.supplyAsync(tareaSimulada("nested"));
	 //CompletableFuture<String> nestedCompletable = CompletableFuture.completedFuture("nested");
	
	 CompletableFuture<Void> collector = callingCompletable.acceptEither(nestedCompletable, results::add);
	
	 pauseSeconds(2);
	 assertEquals(collector.isDone(), true);
	 assertEquals(results.size(), 1);
	 assertEquals(results.contains("calling"), true);
	 assertEquals(results.contains("nested"), false);
	}
	
	private Supplier<String> tareaSimulada(String string) {
		Supplier<String> resultado = new Supplier<String>() {
			@Override
			public String get() {				
				return string;
			}			
		};
		return resultado;	
	}
	
	 private void pauseSeconds(int i) {
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
