package com.proyecto.java8.Optional;

import java.util.Optional;
import java.util.function.Function;

public class Optional2 {

	public static void main(String[] args) {
		Function<String, String> obtenerSegundaPalabra = (String s) ->{
			return s.split(" ").length > 1 ? s.split(" ")[1] : null;
		};
		
		Function<String, Integer> contarLetras = t -> t.length();
		
		Integer count = obtenerSegundaPalabra.andThen(contarLetras).apply("Juan Diego");
		System.out.println(count);
		
		Optional<String> miOptional = Optional.ofNullable(obtenerSegundaPalabra.apply("Juan Diego"));
		
		
		if(miOptional.isPresent()){
			miOptional.ifPresent(System.out::println);
		}else {
			String mensaje = miOptional.orElse("Vacio orElse");
			System.out.println(mensaje);
		}
		
		Optional.ofNullable(obtenerSegundaPalabra.apply("Juan Diego")).ifPresent(System.out::println);
		
		Optional.ofNullable(obtenerSegundaPalabra.apply("Juan Diego")).map(contarLetras).ifPresent(System.out::println);
		
	
	}
}
