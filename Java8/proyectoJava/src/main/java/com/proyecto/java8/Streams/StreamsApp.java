package com.proyecto.java8.Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

	private List<String> lista;
	private List<String> numeros;
	
	public StreamsApp(){
		lista = new ArrayList<>();		
		lista.add("Juan Diego");
		lista.add("Sebastian");
		lista.add("Jose Ignacio");
		lista.add("Adriana");
		
		numeros = new ArrayList<>();		
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
		numeros.add("4");
	}
		
	public void filtrar(){
		//LAMBDA
		//lista.stream().filter(x -> x.startsWith("J")).forEach(x -> System.out.println(x));
		
		//Metodo referencia		
		lista.stream().filter(x -> x.startsWith("J")).forEach(System.out::println);				
	}
	
	public void ordenar(){
		//Forma Ascendente
		lista.stream().sorted().forEach(System.out::println);
		
		//Forma Descendente
		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
	}
	
	public void transformar(){
		//lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		/*for(String x: numeros){
			int num = Integer.parseInt(x) + 1;
			System.out.println(num);
		}*/
		
		numeros.stream().map(x-> Integer.parseInt(x)+1).forEach(System.out::println);
	}
	
	public void limitar(){
		lista.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar(){	
		long x = lista.stream().count();
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		//app.filtrar();
		//app.ordenar();
		//app.transformar();
		app.limitar();
		app.contar();
	
	}
}
