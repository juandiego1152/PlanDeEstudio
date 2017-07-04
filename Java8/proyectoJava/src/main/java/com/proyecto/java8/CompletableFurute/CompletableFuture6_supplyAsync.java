package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableFuture6_supplyAsync {

	//private static ExecutorService service = Executors.newCachedThreadPool();

	@Test
	public void test() {
	
	}

	@Test
    public void test_supply_async() throws Exception {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> tareaSimulada(1, "Final Result"));
        assertEquals(completableFuture.get(), "Término");
    }

	private String tareaSimulada(int i, String string) {
		String finalx = "Término";
		return finalx;
	}
}
