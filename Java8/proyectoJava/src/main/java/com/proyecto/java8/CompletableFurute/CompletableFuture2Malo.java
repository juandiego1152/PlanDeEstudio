package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFuture2Malo {

	// https://blog.logentries.com/2015/07/playing-with-java-8s-completable-futures/
	public CompletableFuture<Object> countEvents() {	
		CompletableFuture<Object> result = new CompletableFuture<>();
	    AtomicInteger count = new AtomicInteger();
	    Observable.just("1", "2", "3", "err", "4").subscribe(ev -> {
	            try {
	                int x = Integer.parseInt(ev);
	                count.set(count.get() + x);
	            } catch (NumberFormatException e) { }
	        },
	        throwable -> result.complete(0);
	        () -> {
	            try {
	                //simulate io delay
	                Thread.sleep(3000);
	            } catch (InterruptedException e) { }
	            result.complete(count.get());
	        }
	    );
	    return result;
	}
	
	public static void main(String[] args) {
		
	}
	
	public void mensaje(){
		CompletableFuture<String> data = countEvents()
		    .thenApply(count -> {
		    	int transformedValue = count;
		        //int transformedValue = count * 25;
		        return transformedValue;
		    }).thenApply(transformed -> "data-" + transformed);

		try {
		    System.out.println(data.get());
		} catch (InterruptedException | ExecutionException e) {
		    e.printStaceTrace();
		}
	}


}


