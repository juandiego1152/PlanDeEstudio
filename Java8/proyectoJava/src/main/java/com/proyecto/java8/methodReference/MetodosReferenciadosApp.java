package com.proyecto.java8.methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MetodosReferenciadosApp {

	public static void referenciarMetodoStatic(){
		System.out.println("Método Referido Static");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario(){
		String[] nombres = {"Juan", "Diego","Sebastian"};
		
		//ORGANIZAMOS EL ARREGLO EN ORDEN ASCEDENTE
		/*Arrays.sort(nombres, new Comparator<String>(){
			public int compare(String o1, String o2){
				return o1.compareTo(o2);
			}
		});*/
		
		//REALIZAMOS LO MISMO QUE EN ESTAS LINEAS ANTERIORES PERO SIMPLIFICADO EN UNA EXPRESION LAMBDA
		//Arrays.sort(nombres, (s1,s2) -> s1.compareTo(s2));		
		//System.out.println(Arrays.toString(nombres));
		
		
		//ESTA ES OTRA FORMA EN LA QUE REFERENCIAMOS STRING Y EL METOO COMPARE TO Y NOS REALIZA LO MISMO 
		//EN UN CODIGO MAS SIMPLE Y RAPIDO.
		Arrays.sort(nombres, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular(){
		System.out.println("Metodo referido instancia de clase");
	}
	
	public void referenciaConstructor(){
		
		//Aca estamos iniciando la clase iPersona para implementar la interface crear y enviar los datos a la clase Persona
		/*iPersona iPersona = new iPersona() {			
			@Override
			public Persona crear(int id, String nombre) {				
				return new Persona(id, nombre);
			}
		};
		iPersona.crear(1, "Juan Diego");
		*/
		
		//REALIZAMOS LO DEL CODIGO ANTERIOR PERO CON METODO LAMBDA,
		//LLAMAMOS LA INTERFACE PERSONA2 PARA CREAR Y ENVIAR LOS DATOS DE PERSONA.
		
		/*iPersona ipersona2 = (x,y)->(new Persona(x,y));
		Persona per = ipersona2.crear(1, "Juan Diego");
		System.out.println(per.getId()+ " - " + per.getNombre());*/
		
		
		//CODIGO PERO REFERENCIANDO EL METODO.
		iPersona iper3 = Persona::new;
		Persona per = iper3.crear(1, "Sebastian");
		System.out.println(per.getId()+ " - " + per.getNombre());
		
	}
	
	public void operar(){
		//Operacion op = () -> MetodosReferenciadosApp.referenciarMetodoStatic();
		//op.saludar();
		
		Operacion op2 = MetodosReferenciadosApp::referenciarMetodoStatic;
		op2.saludar();
	}
	
	public static void main(String[] args) {
		MetodosReferenciadosApp app = new MetodosReferenciadosApp();
		
		//REFERENCIA A METOOD STATICO		
		//app.operar();
		
		//REFERENCIA A OBJETO ARBITRARIO
		//app.referenciarMetodoInstanciaObjetoArbitrario();
		//op.saludar();
		
		//REFERENCIA A UN OBJETO EN PARTICULAR
		//Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		//op.saludar();
		
		
		//REFERENCIA A CONSTRUCTOR
		Operacion op = app::referenciaConstructor;
		op.saludar();
	}
}
