package com.proyecto.java8.CompletableFurute;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;

public class CompletableFuture28_Ejemplos {

		private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		private static final ExecutorService execut = Executors.newCachedThreadPool();
		
		@Test
		public void test(){
			Assert.assertEquals(crearNombre(), "Juan Diego Londoño");
			Assert.assertEquals(conventir("Juan Diego Londoño"), "JUAN DIEGO LONDOÑO");
		}
		
		public static void main(String[] args) {
			CompletableFuture28_Ejemplos app = new CompletableFuture28_Ejemplos();
			app.completableFuture();
		}
		
		public void completableFuture(){
			CompletableFuture.supplyAsync(this::crearNombre,execut).thenApply(this::conventir).thenAccept(this::resultadoFinal);
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
		
		public void resultadoFinal(String resultado){
			LOG.info("El mensaje final es: " + resultado);
		}
}
