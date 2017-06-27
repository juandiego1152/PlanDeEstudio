package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class Future13 {

	@Test
	public void test() {
		
	}
	
	@Test
    public void test_several_stage_combinations() throws Exception {
        Function<String,CompletableFuture<String>> upperCaseFunction = s -> CompletableFuture.completedFuture(s.toUpperCase());

        CompletableFuture<String> stage1 = CompletableFuture.completedFuture("the quick ");

        CompletableFuture<String> stage2 = CompletableFuture.completedFuture("brown fox ");

        CompletableFuture<String> stage3 = stage1.thenCombine(stage2,(s1,s2) -> s1+s2);

        CompletableFuture<String> stage4 = stage3.thenCompose(upperCaseFunction);

        CompletableFuture<String> stage5 = CompletableFuture.supplyAsync(tareaSimulada("jumped over"));

        CompletableFuture<String> stage6 = stage4.thenCombineAsync(stage5,(s1,s2)-> s1+s2);

        CompletableFuture<String> stage6_sub_1_slow = CompletableFuture.supplyAsync(tareaSimulada("fell into"));

        CompletableFuture<String> stage7 = stage6.applyToEitherAsync(stage6_sub_1_slow,String::toUpperCase);

        CompletableFuture<String> stage8 = CompletableFuture.supplyAsync(tareaSimulada(" the lazy dog"));

        CompletableFuture<String> finalStage = stage7.thenCombineAsync(stage8,(s1,s2)-> s1+s2);

        assertEquals(finalStage.get(),"THE QUICK BROWN FOX JUMPED OVER the lazy dog");

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
