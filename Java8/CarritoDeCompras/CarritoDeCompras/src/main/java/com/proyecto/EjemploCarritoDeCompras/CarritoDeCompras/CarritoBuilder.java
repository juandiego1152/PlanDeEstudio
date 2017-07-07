package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import java.util.ArrayList;

public class CarritoBuilder {

    ArrayList<Integer> precios = new ArrayList<Integer>();

    public CarritoBuilder(int size){

        for(int i = 0; i < size; i++){

            Double random = Math.random()*100+1;
            precios.add(random.intValue());
        }
    }

    public CarritoBuilder(int size, int value){

        for(int i = 0; i < size; i++){

            precios.add(value);
        }
    }

    public CarritoDeLaCompra build(){

        return new CarritoDeLaCompra(this.precios);
    }

    public CarritoBuilder add(Integer nuevoValor){

        precios.add(nuevoValor);
        return this;
    }
    
    public CarritoBuilder addMultiple(Integer size, int value){
        for(int i = 0; i < size; i++){
            precios.add(value);
        }
        return this;
        
    }
    
    public boolean detectarError() {
    	boolean negativeFind = false;	
    	for (Integer precio : precios) {	
		     if (precio < 0) {	
		         negativeFind = true;
		     }
		  }  
	  return negativeFind;
	}
}