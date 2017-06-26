package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Future7 {

	@Test
	public void test() {
		
	}

	private static ExecutorService service = Executors.newCachedThreadPool();
	
	/* @Test
    public void test_then_run_async() throws Exception {
        Map<String,String> cache = new HashMap<>();
        cache.put("key","value");
        CompletableFuture<String> taskUsingCache = CompletableFuture.supplyAsync(simulatedTask(1,cache.get("key")));
        CompletableFuture<Void> cleanUp = taskUsingCache.thenRunAsync(cache::clear);
        cleanUp.get();
        String theValue = taskUsingCache.get();
        assertEquals(cache.isEmpty(),true);
        //assertEquals(theValue,"value");
    }

	private String simulatedTask(int i, String string) {
		
		return "value";
	}
	
	@Test
	public void test_accept_result() throws Exception {
		List<String> results = new ArrayList<String>();
        CompletableFuture<String> task = CompletableFuture.supplyAsync(simulatedTask(1, "add when done"), service);
        CompletableFuture<Void> acceptingTask = task.thenAccept(results::add);
    
        assertEquals(acceptingTask.isDone(), true);
        assertEquals(results.size(), 1);
        assertEquals(results.contains("add when done"), true);
    }*/
	
	
	@Test
	public void test_then_compose() throws Exception {

	 Function<Integer,Supplier<List<Integer>>> obtenerPrimerosNumeros = num ->
	                ()->Stream.iterate(num, i -> i + num).limit(10).collect(Collectors.toList());


	 Supplier<List<Integer>> numeros = obtenerPrimerosNumeros.apply(13);

	 
	
	 CompletableFuture<List<Integer>> obtenerNumeros = CompletableFuture.supplyAsync(numeros, service);


	 Function<List<Integer>, CompletableFuture<Integer>> suma = numerosx ->
	            CompletableFuture.supplyAsync(() -> numerosx.stream().mapToInt(Integer::intValue).sum());


	  CompletableFuture<Integer> summedMultiples = obtenerNumeros.thenComposeAsync(suma, service);

	  assertEquals(summedMultiples.get(), new Integer(715));
	  }

}
