package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;


import org.junit.Assert;
import org.junit.Test;

public class CarritoDeLaCompraTest {

    @Test
    public void contarItems() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(30);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(30, carritoDeLaCompra.contarNumeroProductos());
    }

    @Test
    public void calcularTotalPrecio() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoDeLaCompra carritoDeLaCompra = builder.build();
        Assert.assertEquals(300, carritoDeLaCompra.calcularPrecioTotal());

    }
}