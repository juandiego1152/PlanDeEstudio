package com.proyecto.java8.DefaultMethods;


public class DefaultMethod implements PersonaA, PersonaB{
	
	
	@Override
	public void hablar(){
		/*En esta linea estamos diciendo que como las dos clases que estamos importando tienen el mismo metodo, 
		tenemos que escojer cual es la clase que queremos utilizar.*/
		
		//PersonaB.super.hablar();
		
		//VAMOS A SOBREESCRIBIR EL METODO.
		
		System.out.println("Sobre escribiendo el metodos hablar.");
	}
	
	
	public void caminar() {
		System.out.println("Hola coders");
		
	}	

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.hablar();
		//app.caminar();

	}


}
