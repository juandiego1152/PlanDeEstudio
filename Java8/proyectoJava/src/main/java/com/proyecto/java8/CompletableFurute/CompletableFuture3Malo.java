package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
public class CompletableFuture3Malo {

	public CompletableFuture<String>  resultado;
	
	public CompletableFuture<String> getResultado() {
		return resultado;
	}

	public void setResultado(CompletableFuture<String> resultado) {
		this.resultado = resultado;
	}

	public static void main(String[] args) throws Exception {
		CompletableFuture3Malo  app = new CompletableFuture3Malo();
		System.out.println("Entro al main");
		app.test_completed_future();	
	}	
	
	public void test_completed_future() throws Exception {
		System.out.println("Entro al test");
		String expectedValue = "the expected value";
		CompletableFuture<String> alreadyCompleted = CompletableFuture.completedFuture(expectedValue);	
		setResultado(alreadyCompleted);	
	  	 
	}

	/*public void correrHilo() throws InterruptedException, ExecutionException{
		 CompletableFuture<Void> hilo =  CompletableFuture.runAsync(new RHilo());
		 		
	}*/

	
}
