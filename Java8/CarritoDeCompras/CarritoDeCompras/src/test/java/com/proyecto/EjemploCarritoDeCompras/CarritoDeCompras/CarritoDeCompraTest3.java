package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;


import static org.junit.Assert.*;

import org.junit.Test;

public class CarritoDeCompraTest3 {

	@Test
	public void test() {
		
	}

	@Test
	public void shouldCalculateTotalDiscount() throws Exception {
		CarritoBuilder builder = new CarritoBuilder(20,100);
		CarritoDeLaCompra carritoDeLaCompra = builder.build();
		assertEquals(100, carritoDeLaCompra.calcularDescuentoTotal(100));

	}
}
