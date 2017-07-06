package com.proyecto.java8.CompletableFurute;

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

public class CompletableFuture7_thenComposeAsync_Y_Stream {

	@Test
	public void test() {
		
	}

	private static ExecutorService service = Executors.newCachedThreadPool();
	
		
	@Test
	public void test_then_compose() throws Exception {

	 Function<Integer,Supplier<List<Integer>>> obtenerPrimerosNumeros = num ->
	                ()->Stream.iterate(num, i -> i + num).limit(10).collect(Collectors.toList());


	 Supplier<List<Integer>> numeros = obtenerPrimerosNumeros.apply(13);
	 
		 CompletableFuture<List<Integer>> obtenerNumeros = CompletableFuture.supplyAsync(numeros, service);


	 Function<List<Integer>, CompletableFuture<Integer>> suma = numerosx ->
	            CompletableFuture.supplyAsync(() -> numerosx.stream().mapToInt(Integer::intValue).sum());


	  CompletableFuture<Integer> resultado = obtenerNumeros.thenComposeAsync(suma, service);

	  assertEquals(resultado.get(), new Integer(715));
	  }

	
}
