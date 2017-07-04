package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableFuture9_thenCombine {

	@Test
	public void test() {
		
	}
	
	@Test
	public void completableCombine() throws Exception {
	 CompletableFuture<String> completableAsincrono = CompletableFuture.supplyAsync(tareaSimulada("valor calculado"));
	 CompletableFuture<String> CompletableConElValor = CompletableFuture.completedFuture("valor conocido");
	
	 BinaryOperator<String> resultadoCalculo = (f, s) -> "tomando un " + f + " y añadiendo un " + s;
	 CompletableFuture<String> combined = completableAsincrono.thenCombine(CompletableConElValor, resultadoCalculo);
	
	 assertEquals(combined.get(),"tomando un valor calculado y añadiendo un valor conocido");
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
