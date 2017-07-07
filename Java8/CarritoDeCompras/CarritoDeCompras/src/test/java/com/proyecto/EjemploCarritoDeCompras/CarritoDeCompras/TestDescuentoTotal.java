package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDescuentoTotal {

	@Test
	public void shouldCalculateTotalDiscountLambda() throws Exception {
	 
	    CarritoBuilder builder = new CarritoBuilder(20,100);
	    CarritoDeLaCompra carritoDeLaCompra = builder.build();
	    assertEquals(100, carritoDeLaCompra.calcularDescuentoTotalLambda(100));	 
	    
	}
	
	@Test
	public void shouldCalculateTotalDiscount() throws Exception {
		CarritoBuilder builder = new CarritoBuilder(20,100);
		CarritoDeLaCompra carritoDeLaCompra = builder.build();
		assertEquals(100, carritoDeLaCompra.calcularDescuentoTotal(100));

	}
}

