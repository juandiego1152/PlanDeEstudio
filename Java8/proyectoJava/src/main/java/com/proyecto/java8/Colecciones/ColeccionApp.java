package com.proyecto.java8.Colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

public class ColeccionApp {

	private List<String> lista;
	
	private void llenarLista(){
		lista = new ArrayList<>();		
		lista.add("Juan Diego");
		lista.add("Juan");
		lista.add("Diego");
		lista.add("Sebastian");
	}
	
	public void usarForEach(){
		
		//Recorremo la lista como siempre se hace con foreach
		/*for(String elemento: lista){
			System.out.println(elemento);
		}*/
		
		//Recorremos la lista con una expresion lambda
		//lista.forEach(x -> System.out.println(x));
		
		//recorremos la lista con una expresion funcional.
		lista.forEach(System.out::println);
	}
	
	public void usarRemoveIf(){
		
		//RECORREMOS LA LISTA Y ELIMINAMOS EL OBJETO QUE SEA IGUAL A JUAN
		/*
		Iterator<String> it = lista.iterator();		
		while(it.hasNext()){
			if(it.next().equalsIgnoreCase("Juan")){
				it.remove();				
			}
		}*/
		
		
		//RECORREMOS LA LISTA Y ELIMINAMOS EL OBJETO CON UNA EXPRESION LAMBDA;
		lista.removeIf(x -> x.equalsIgnoreCase("Juan"));
		
	}
	
	public void usarSort(){
		lista.sort((x,y) -> x.compareTo(y));
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		//app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();
	}
	
}
