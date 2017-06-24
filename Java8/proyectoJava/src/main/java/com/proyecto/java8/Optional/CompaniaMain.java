package com.proyecto.java8.Optional;

import java.util.Iterator;
import java.util.Optional;

public class CompaniaMain {

	public static void main(String[] args) {
		
		Compania compañia = llenarInformacion();
		
		for (Departamento dept:compañia.getDepartamentos()) {
			
			if(dept.getGerente().isPresent())System.out.println(dept.getName() +" Gerente: "+ dept.getGerente().get().getName());
			//System.out.println(dept.getName() +" Gerente: "+ dept.getGerente().get().getName());
			else System.out.println(dept.getName()+" Gerente: N/A");
		}
						
	}
	
	public static Compania llenarInformacion(){
		
		Compania compañia = new Compania();
		
		Departamento departamento01 = new Departamento("Desarrollo Java");		
		//Gerente gerente01 = new Gerente("Juan Diego");	
		Optional<Gerente>  gerente01 = Optional.of(new Gerente("Juan Diego"));
		departamento01.setGerente(gerente01);
		compañia.addDepartamentos(departamento01);
		
		
		Departamento departamento02 = new Departamento("Base de datos");		
		//Gerente gerente02 = new Gerente("Sebastian");
		Optional<Gerente>  gerente02 = Optional.of(new Gerente("Sebastian"));
		departamento02.setGerente(gerente02);
		compañia.addDepartamentos(departamento02);
		
		Departamento departamento03 = new Departamento("Desarrollo Web");		
		compañia.addDepartamentos(departamento03);
		
		return compañia;
	}
}
