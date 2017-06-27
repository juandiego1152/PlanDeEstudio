package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;

public class Future8 {


	@Test
	public void testTareasCombinadas() throws Exception {
	 CompletableFuture<String> primeraTarea = CompletableFuture.supplyAsync(tareaSimulada(3, "Combinar"));

	 CompletableFuture<String> segundaTarea = CompletableFuture.supplyAsync(tareaSimulada(2, "todas las tareas"));

	 CompletableFuture<String> tareasCombinadas = primeraTarea.thenCombineAsync(segundaTarea, (f, s) -> f + " " + s);

	 assertEquals(tareasCombinadas.get(), "Combinar todas las tareas");
	 //assertNull(tareasCombinadas.get());
	}


	private Supplier<String> tareaSimulada(int i, String string) {
		Supplier<String> resultado = new Supplier<String>() {
			@Override
			public String get() {				
				return string;
			}			
		};
		return resultado;	
	}

	
}
