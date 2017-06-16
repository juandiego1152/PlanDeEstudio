package com.proyecto.java8.proyectoJava;

public class Sintaxis {

	public double probarSintaxis() {
		//OTROS EJEMPLOS DE SINTAXIS
		
		//Operacion operacion = (double x, double y) -> (x+y)/2;
		
		//Operacion operacion = (double x, double y) ->{return (x+y)/2;};
		
		
		/*Operacion operacion = (double x, double y) ->{
			double a = 2.0;
			System.out.println(a);			
			return (x+y)/2 + a;
			};
		*/
		
		
		Operacion operacion = (x, y) -> (x+y)/2;
		
		return operacion.calcularPromedio(2, 3);
		
		
		//EN ESTA EXPRESION NO VAMOS A USAR PARAMETROS
		
		//Operacion operacion = () -> 2;
		
		
		/*Operacion operacion = () -> {
			int x = 2;
			int y = 3;
			return x + y;
		};
		
		return operacion.calcularPromedio();*/
						
	}
	
	public static void main(String[] args){
		Sintaxis app = new Sintaxis();
		System.out.println(app.probarSintaxis());
	}
}
