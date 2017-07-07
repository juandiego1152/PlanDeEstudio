package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestErroresEnPrecios {

		
	@Test
	public void detectarErrorCuandoPrecioNegativo(){
	 
		CarritoBuilder builder = new CarritoBuilder(20,100);
		builder.add(-1);
		builder.addMultiple(10,-100);
		CarritoDeLaCompra carritoDeLaCompra = builder.build();
		
		assertTrue(carritoDeLaCompra.detectarError());
	 
	}
	
	@Test
	public void detectarErrorCuandoPrecioNegativoAnyMatch(){

	     CarritoBuilder builder = new CarritoBuilder(20,100);
	     builder.add(-1);
	     builder.addMultiple(10,-100);
	     CarritoDeLaCompra carritoDeLaCompra = builder.build();
	     assertTrue(carritoDeLaCompra.detectarErrorAnyMatch());

	}
}
