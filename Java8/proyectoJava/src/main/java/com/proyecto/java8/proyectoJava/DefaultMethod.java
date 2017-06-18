package com.proyecto.java8.proyectoJava;

public class DefaultMethod implements PersonaA{
	
	
	public void caminar() {
		System.out.println("Hola coders");
		
	}
	

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.hablar();
	}


}
