package com.proyecto.java8.CompletableFurute;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;



public class CompletableFuture30_Ejemplos {

	private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final ExecutorService execut = Executors.newCachedThreadPool();
	
	List<Double> lista1 = new ArrayList<Double>();
	List<Double> lista2 = new ArrayList<Double>();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture30_Ejemplos app = new CompletableFuture30_Ejemplos();
		app.llamarMetodo();
		
	}
	
	public void llamarMetodo() throws InterruptedException, ExecutionException{
		CompletableFuture<Double> primeraLista = CompletableFuture.supplyAsync(() -> llenarLista1(), execut)
				.thenApply(s -> sumarLista(s));
		CompletableFuture<List<Double>> segundaLista = CompletableFuture.supplyAsync(() -> llenarLista2(), execut);
		
		CompletableFuture<Double> sumaSegundaLista = segundaLista.thenApply(s -> sumarLista(s));
		
		//CompletableFuture<Void> restultado = primeraLista.thenCombineAsync(sumaSegundaLista, (x,y) -> x + y).thenAccept(s ->LOG.info("resultado: " + s));
		
		/*Como no estamos usando la variable resultado ya que esta terminando la ejecucion de la linea
		con el thenApply entonces no la inicializare.*/
		
		primeraLista.thenCombineAsync(sumaSegundaLista, (x,y) -> x + y).thenAccept(s ->LOG.info("resultado: " + s));
		
		/* OTRA FORMA DE LLAMAR EL RESULTADO.
		 
		CompletableFuture<Double> restultado = primeraLista.thenCombineAsync(sumaSegundaLista, (x,y) -> x + y);
		LOG.info("Resultado " + restultado.get());*/
						
	}
	
	public double sumarLista(List<Double> lista){		
		int resultado = lista.stream().mapToInt(X -> X.intValue()).sum();
		//double resultado = lista.forEach(x -> x);
		return resultado;		
	}	
			
	public double suma(double x, double y){
		double resultadoFinal = x + y;
		return resultadoFinal;
	}
	
	public List<Double> llenarLista1(){
		for (int i = 0; i < 10; i++) {
			lista1.add((Math.random())+1 );
		}
		lista1.forEach(System.out::println);
		return lista1;
	}
	
	public List<Double> llenarLista2(){		
		lista2.add(2.0);
		lista2.add(2.0);
		lista2.add(2.0);
		lista2.add(2.0);
		lista2.add(2.0);
		
		lista2.add(3.0);
		lista2.add(3.0);
		lista2.add(3.0);
		lista2.add(3.0);
		lista2.add(3.0);
		lista2.forEach(System.out::println);
		return lista2;
	}
}
