package com.proyecto.java8.proyectoJava;

public interface PersonaA {
	public void caminar();
	
	default public void hablar(){
		System.out.println("Hola Coders - persona A");
	}
}
