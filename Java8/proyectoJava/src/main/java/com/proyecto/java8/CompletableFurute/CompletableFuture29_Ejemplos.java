package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;

public class CompletableFuture29_Ejemplos {
	private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final ExecutorService execut = Executors.newCachedThreadPool();
	
	@Test
	public void test(){
		Assert.assertEquals(crearNombre(), "Juan Diego Londoño");
		Assert.assertEquals(conventir("Juan Diego Londoño"), "JUAN DIEGO LONDOÑO");
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture29_Ejemplos app = new CompletableFuture29_Ejemplos();
		app.completableFuture();
	}
	
	public void completableFuture() throws InterruptedException, ExecutionException{
		CompletableFuture<String> resutadoX = CompletableFuture.supplyAsync(this::crearNombre,execut).thenApply(this::conventir);
		LOG.info("Mensaje del resultado " + resutadoX.get());
	}
	
	
	public String crearNombre(){
		String nombre = "Juan Diego Londoño";
		Sleep.sleepSeconds(2);
		return nombre;
	}
	
	public String conventir(String variable){
		String retorno = variable.toUpperCase();
		Sleep.sleepSeconds(2);
		return retorno;
	}
}
