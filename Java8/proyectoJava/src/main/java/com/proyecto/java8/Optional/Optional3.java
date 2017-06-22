package com.proyecto.java8.Optional;

import java.util.Optional;

public class Optional3 {

	public static void main(String[] args) {
		Integer valor1 = 25;
		Integer valor2 = null;
		String cadena1 = null;
		
		Optional<Integer>  a = Optional.ofNullable(valor1);
		Optional<Integer>  b = Optional.ofNullable(valor2);
		
		Optional<Integer>  c = Optional.empty();
		//c.ofNullable(cadena1);
		Optional.ofNullable(cadena1);
		
		System.out.println("c "+ c.isPresent());
		//Optional<Integer>  d = Optional.of(valor2);
		
		//System.out.println(d.get());
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());
		System.out.println(a.orElse(1));
		System.out.println(b.orElse(2));
		
	
		
		Integer suma = suma(a,b);
		System.out.println("Suma: " + suma);
	}

	private static Integer suma(Optional<Integer> a, Optional<Integer> b) {
		Integer valor1 = a.orElse(0);
		Integer valor2 = b.orElse(0);
		return valor1 + valor2;
	}
	
	
}
