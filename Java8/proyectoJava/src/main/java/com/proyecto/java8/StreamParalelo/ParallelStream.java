package com.proyecto.java8.StreamParalelo;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	private List<Integer> numeros;
	
	public void llenar(){
		numeros = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			numeros.add(i);
		}
	}
	
	public void probarStream(){
		numeros.stream().forEach(System.out::println);
	}
	
	public void probarParalelo(){
		numeros.parallelStream().forEach(System.out::println);
	}
	
	
	public void miEjemplo(){
	List lista= Arrays.asList(100,200,300,100,500);
	 
		double total=lista.parallelStream().parallel().filter(elemento->(elemento>200))
				.mapToDouble(elemento->elemento*1.21).sum();
	 
		System.out.println(total);
		}
	}
	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
		//app.probarStream();
		app.probarParalelo();
	}
}
