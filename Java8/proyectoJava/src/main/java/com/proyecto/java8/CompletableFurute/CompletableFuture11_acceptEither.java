package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableFuture11_acceptEither {

	@Test
	public void test() {
	
	}


	@Test
	public void completableAcceptEither() throws Exception {
	List<String> results = new ArrayList<String>();
		
	 CompletableFuture<String> tarea1 = CompletableFuture.supplyAsync(tareaSimulada("tarea 1"));
	 CompletableFuture<String> tarea2 = CompletableFuture.supplyAsync(tareaSimulada("tarea 2"));
	
	 CompletableFuture<Void> collector = tarea1.acceptEither(tarea2, results::add);
	
	 pauseSeconds(2);
	 assertEquals(collector.isDone(), true);
	 assertEquals(results.size(), 1);
	 assertEquals(results.contains("tarea 1"), true);
	 assertEquals(results.contains("tarea 2"), false);
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
	
	 private void pauseSeconds(int i) {
    	try{
			//Thread.sleep(i * 1000);
    		int finalx = i * 1000;
    		int x = 0;
    		while (x < finalx) {
    			System.out.println(x);
    			Thread.sleep(1000);
    			x = x + 1000;
			}		
		}catch(InterruptedException e){	}	
		
	}
}
