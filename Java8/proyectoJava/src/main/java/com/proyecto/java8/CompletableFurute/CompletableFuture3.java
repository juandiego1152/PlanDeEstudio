package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import org.junit.Test;
import junit.framework.TestCase;

public class CompletableFuture3 extends TestCase {

	@Test
	public void test_completed_future() throws Exception {
		  String expectedValue = "the expected value";
		  CompletableFuture<String> alreadyCompleted = CompletableFuture.completedFuture(expectedValue);	
		  assertEquals(alreadyCompleted.get(), expectedValue);
		  		  		  
	}		

}
