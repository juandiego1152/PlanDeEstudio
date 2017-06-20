package com.proyecto.java8.proyectoJava;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LambdaApp {

    
    public void ordenar(){

    	List<String> lista = new ArrayList<>();
    	lista.add("MitoCode");
    	lista.add("Mito");
    	lista.add("Code");
    	
    	/*ESTE ES EL CODIGO NORMAL QUE HARIAMOS EN JAVA 1.7
    	 * 
    	 * Collections.sort(lista, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {			
				return o1.compareTo(o2);
			}
    		
    	});
    	
    	PERO EL CODIGO SIGUIENTE ES COMO LO USAMOS EN JAVA 8,
    	PARA ESO USAMOS LA LAMBDAS SU ESTRUCTURA ES (PARAMETROS ) -> "OPERADOR"  OPERACION
    	*/
    	
    	Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
        	
    	for(String elemento: lista){
    		System.out.println(elemento);
    	}
    }
    
    
    
    

    public void calcular(){
    	//JAVA 7
    	/*Operacion operacion = new Operacion(){
			@Override
			public double calcularPromedio(double n1, double n2) {
				// TODO Auto-generated method stub
				return (n1+n2)/2;
			}    		
    	};    	
    	System.out.println(operacion.calcularPromedio(2, 3));*/
    	
    	
    	//JAVA 8 LAMBDA
    	
    	
    	Operacion operacion = (double x, double y) -> (x+y)/2;
    	//System.out.println(operacion.calcularPromedio(2, 3));
    	
    	
    }
    
    public static void main( String[] args )
    {
        LambdaApp app = new LambdaApp();
        app.ordenar();
        app.calcular();
    }
}
