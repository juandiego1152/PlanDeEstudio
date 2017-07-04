package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.Test;

public class CompletableFuture12_runAfterEitherAsync {

	@Test
	public void test() {
		
	}


	 @Test
	 public void test_run_after_either() throws Exception {
	 List<String> results = new ArrayList<String>();
		 
	 CompletableFuture<Void> run1 = CompletableFuture.runAsync(() -> {
		 		Sleep.sleepSeconds(4);
	            results.add("primero");
	    });
	
	 CompletableFuture<Void> run2 = CompletableFuture.runAsync(() -> {
		 		Sleep.sleepSeconds(3);
	            results.add("segundo");
	    });
	
	  CompletableFuture<Void> finisher = run1.runAfterEitherAsync(run2,() -> results.add(results.get(0).toUpperCase()));
	
	 Sleep.sleepSeconds(5);
	 assertEquals(finisher.isDone(),true);
	 //assertEquals(results.get(1),"PRIMERO");
	 assertEquals(results.get(1),"SEGUNDO");
	 }	 
	
}
