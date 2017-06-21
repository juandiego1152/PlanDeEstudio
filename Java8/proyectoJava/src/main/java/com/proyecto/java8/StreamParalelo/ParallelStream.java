package com.proyecto.java8.StreamParalelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
	 
		double total=((Stream<Integer>) lista.stream().parallel()).filter(elemento->(elemento>200))
				.mapToDouble(elemento->elemento*1.21).sum();
	 
		System.out.println(total);
	}
	


	/*ALGUNAS LECTURAS Y TUTORIALES DE STREAM PARALELO
	 * https://dosideas.com/noticias/java/983-java-8-mas-alla-de-los-lambdas
	 * 
	 * https://www.google.com.co/url?sa=t&rct=j&q=&esrc=s&source=web&cd=10&ved=0
	 * ahUKEwj_wbmI4c3UAhUBRyYKHRgxDtkQFghZMAk&url=http%3A%2F%2Frossainz.cs.buap.
	 * mx%2FConcurrente2017%2FDiapositivas%2FCap4_Programacion_Paralela.ppsx&usg=
	 * AFQjCNFB3tM-5TfRNffR5n4yqV4rSzqRGA&sig2=w0ggkgj68oNYEeQE35g3Fw
	 */
	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
		//app.probarStream();
		app.probarParalelo();
	}
}
