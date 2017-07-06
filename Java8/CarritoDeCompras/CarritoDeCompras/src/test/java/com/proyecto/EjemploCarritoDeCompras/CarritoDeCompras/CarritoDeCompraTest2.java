package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import org.junit.Test;

import junit.framework.Assert;

public class CarritoDeCompraTest2 {

	
	@Test
	public void calcularTotalPrecioLambda() throws Exception {

	   CarritoBuilder builder = new CarritoBuilder(60, 5);
	   CarritoDeLaCompra carritoDeLaCompra = builder.build();
	   Assert.assertEquals(300, carritoDeLaCompra.calcularPrecioTotalLambda());
	}

	@Test
	public void CalcularTotalPrecioReferenciaMetodo() throws Exception {

	   CarritoBuilder builder = new CarritoBuilder(60,5);
	   CarritoDeLaCompra carritoDeLaCompra = builder.build();
	   Assert.assertEquals(300, carritoDeLaCompra.calcularPrecioTotalRefMethod());
	}
}
