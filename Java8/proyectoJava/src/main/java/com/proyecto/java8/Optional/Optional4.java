package com.proyecto.java8.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optional4 {	
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Juan Diego");
		lista.add(null);
		lista.add("Sebastian");
		lista.add("Adriana Maria");
		lista.add(null);
		lista.add("Jose Ignacio");
	
		//lista.forEach(x -> Optional.ofNullable(x).ifPresent(System.out::println));
		
		
		for (String list:lista) {
			if(Optional.ofNullable(list).isPresent()){
				System.out.println(list);
			}else {
				System.out.println("N/A");					
			}
		}		
	}
}
