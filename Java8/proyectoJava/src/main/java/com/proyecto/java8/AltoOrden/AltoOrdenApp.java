package com.proyecto.java8.AltoOrden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.security.auth.callback.TextOutputCallback;

public class AltoOrdenApp {
	
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function<String, String> funcion, String valor){		
		System.out.println(funcion.apply(valor));
	}
	
	
	public Function<String, String> mostrar(String mensaje){	
		return (String x) -> mensaje + x;
	}
	
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena){
		lista.stream().filter(this.establecerLogica(cadena)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogica(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogica(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	public static void main(String[] args) {
		AltoOrdenApp app = new AltoOrdenApp();
		app.imprimir(app.convertirMayusculas, "cadena en minuscula");
		
		app.imprimir(app.convertirMinusculas, "CADENA EN MAYUSCULAS");
		
		
		String respuesta = app.mostrar("Hola ").apply("Mensaje Salida");
		System.out.println(respuesta);
		
		
		List<String> lista = new ArrayList<String>();
		lista.add("Juan");
		lista.add("Sebastian");
		lista.add("Jose");
		lista.add("Adriana");
		//app.filtrar(lista, System.out::println, 5, null);
		app.filtrar(lista, System.out::println, 0, "J");
	}
}
