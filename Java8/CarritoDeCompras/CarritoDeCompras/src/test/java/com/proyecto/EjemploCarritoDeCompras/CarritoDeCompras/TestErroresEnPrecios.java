package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestErroresEnPrecios {

		
	@Test
	public void shouldDetectErrorAnThrowRuntimeExceptionWhenAPriceIsNegative(){
	 
		CarritoBuilder builder = new CarritoBuilder(20,100);
		builder.add(-1);
		builder.addMultiple(10,-100);
		CarritoDeLaCompra carritoDeLaCompra = builder.build();
		
		assertTrue(carritoDeLaCompra.detectarError());
	 
	}
}
