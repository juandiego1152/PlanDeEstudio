package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class CompletableFuture12 {

	@Test
	public void test() {
		
	}


	 @Test
	 public void test_run_after_either() throws Exception {
	 List<String> results = new ArrayList<String>();
		 
	 CompletableFuture<Void> run1 = CompletableFuture.runAsync(() -> {
	            pauseSeconds(4);
	            results.add("should be first");
	    });
	
	 CompletableFuture<Void> run2 = CompletableFuture.runAsync(() -> {
	            pauseSeconds(3);
	            results.add("should be second");
	    });
	
	  CompletableFuture<Void> finisher = run1.runAfterEitherAsync(run2,() -> results.add(results.get(0).toUpperCase()));
	
	 pauseSeconds(5);
	 assertEquals(finisher.isDone(),true);
	 //assertEquals(results.get(1),"SHOULD BE FIRST");
	 assertEquals(results.get(1),"SHOULD BE SECOND");
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
