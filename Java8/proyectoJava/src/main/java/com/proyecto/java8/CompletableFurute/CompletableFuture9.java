package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableFuture9 {

	@Test
	public void test() {
		
	}
	
	@Test
	public void test_then_combine_with_one_supplied_value() throws Exception {
	 CompletableFuture<String> completableAsincrono = CompletableFuture.supplyAsync(tareaSimulada("calculated value"));
	 CompletableFuture<String> CompletableConElValor = CompletableFuture.completedFuture("known value");
	
	 BinaryOperator<String> resultadoCalculo = (f, s) -> "taking a " + f + " then adding a " + s;
	 CompletableFuture<String> combined = completableAsincrono.thenCombine(CompletableConElValor, resultadoCalculo);
	
	 assertEquals(combined.get(),"taking a calculated value then adding a known value");
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
}
