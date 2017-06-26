package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;

public class Future8 {

	@Test
	public void test() {
		
	}
	

	@Test
	public void test_then_combine_async() throws Exception {
	 CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(simulatedTask(3, "combine all"));

	 CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(simulatedTask(2, "task results"));

	 CompletableFuture<String> combined = firstTask.thenCombineAsync(secondTask, (f, s) -> f + " " + s);

	 assertEquals(combined.get(), "combine all task results");
	}


	private Supplier<String> simulatedTask(int i, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
