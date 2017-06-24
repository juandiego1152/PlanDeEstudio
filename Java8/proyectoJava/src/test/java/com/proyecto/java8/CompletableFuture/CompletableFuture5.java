package com.proyecto.java8.CompletableFuture;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CompletableFuture5 {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	private static ExecutorService service = Executors.newCachedThreadPool();
	
	@Test
    public void test_run_async(){
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("running async task"), service);
        //utility testing method
        pauseSeconds(3);       
        assertEquals(runAsync.isDone(), true);	      
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
