package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class CompletableFuture1 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		
		ExecutorService executor = Executors.newFixedThreadPool(3);	
		/*Future<String> tarea1 = executor.submit(new CHilo());
		Future<?> tarea2 = executor.submit(new RHilo());
		
		while (!tarea1.isDone() && !tarea2.isDone()) {
							
		}
		System.out.println(tarea1.get());
		System.out.println(tarea2.get());*/
		
		//CompletableFuture<String> tarea1 = executor.submit(new CHilo());
		//CompletableFuture<?> tarea2 = (CompletableFuture<?>) executor.submit(new RHilo());
		//CompletableFuture<?> tarea3 = CompletableFuture.completedFuture(new RHilo());
	
		
		//while (!tarea1.isDone() && !tarea2.isDone()) {
			//while (!tarea2.isDone()) {
						
		//}
		//System.out.println(tarea1.get());
		//System.out.println(tarea2.get());
		
		
		/*Callable<String> respuestaHilo =  new CHilo();
		CompletableFuture<String> respuestaCom = (CompletableFuture<String>) executor.submit(respuestaHilo);
		
		String repuesta = respuestaCom.get();
		System.out.println("Completado: " + repuesta);*/
		
		CompletableFuture<String> respuesta = CompletableFuture.supplyAsync( new CHilo());
		

		
        /*val f = Future { 
			4 + 5
			}
			f.onComplete {
			case Success(num) => { println( "la suma es : " + num )
			case Failure(e) => { println("Hubo un error haciendo la suma")}
			}*/
	}
		
		
	/*public CompletableFuture<String> creacion(){
		
		CompletableFuture<String> future = new CompletableFuture<>();
		CompletableFuture<String> future2 = CompletableFuture.completedFuture("Prueba");
		
		future.complete("Completado");
		
		//CompletableFuture<Void> future3 = CompletableFuture.runAsync((){	}
		return future;
	}*/
				
	
}


