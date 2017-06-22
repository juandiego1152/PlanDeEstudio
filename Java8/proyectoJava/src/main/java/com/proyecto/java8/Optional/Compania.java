package com.proyecto.java8.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Compania {
	private List<Departamento>  depar = new ArrayList<Departamento>();
	public void addDepartamentos(Departamento departamento){
		depar.add(departamento);
	}
	public List<Departamento> getDepartamentos() {return depar;}
}

class Departamento{
	private String nombre;	
	//private Gerente gerente;	
	private Optional<Gerente> gerente = Optional.empty();
	
	
	public Departamento(String name){
		this.nombre = name;}	
	public String getName(){
		return nombre;}	
	/*public Gerente getGerente(){
		return gerente;}	
	public void setGerente(Gerente gerente){
		this.gerente = gerente;}*/
	
	public Optional<Gerente> getGerente(){
		return gerente;
	}
	
	public void setGerente(Optional<Gerente> gerente){
		this.gerente = gerente;
	}
	
}

class Gerente{
	private String nombre;
	public Gerente(String name){
		this.nombre = name;}
	public String getName(){
		return nombre;}
}
