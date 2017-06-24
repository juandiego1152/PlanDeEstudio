package com.proyecto.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;


import junit.framework.TestCase;

public class completableFuture3 extends TestCase {

	@Test
	public void test_completed_future() throws Exception {
		  String expectedValue = "the expected value";
		  CompletableFuture<String> alreadyCompleted = CompletableFuture.completedFuture(expectedValue);	
		  assertEquals(alreadyCompleted.get(), expectedValue);
		  		  		  
	}
	
	

}
