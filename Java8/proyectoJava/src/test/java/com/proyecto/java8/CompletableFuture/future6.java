package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.junit.Test;

public class future6 {

	private static ExecutorService service = Executors.newCachedThreadPool();

	@Test
	public void test() {
	
	}

	@Test
    public void test_supply_async() throws Exception {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> simulatedTask(1, "Final Result"), service);
        assertEquals(completableFuture.get(), "Término");
    }

	private String simulatedTask(int i, String string) {
		String finalx = "Término";
		return finalx;
	}
}
