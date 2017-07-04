package com.proyecto.java8.CompletableFurute;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CompletableFuture5_runAsync {

	@Test
	public void test() {
		
	}

	private static ExecutorService service = Executors.newCachedThreadPool();
	
	@Test
    public void test_run_async(){
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("Corriendo tarea Async"), service);
        pausarSegundos(3);       
        assertEquals(runAsync.isDone(), true);	      
    }
	 
    private void pausarSegundos(int i) {
    	try{
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
