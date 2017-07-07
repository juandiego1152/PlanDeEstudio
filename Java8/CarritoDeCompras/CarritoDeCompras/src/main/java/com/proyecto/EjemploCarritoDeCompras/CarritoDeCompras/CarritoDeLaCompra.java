package com.proyecto.EjemploCarritoDeCompras.CarritoDeCompras;

import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



public class CarritoDeLaCompra {

	//private static final Logger LOGGER = LoggerFactory.getLogger(CarritoDeLaCompra.class);
	//private static final Logger LOGGER = LogManager.getLogger(CarritoDeLaCompra.class);
	final static Logger LOGGER = Logger.getLogger(CarritoDeLaCompra.class);
	
	
    private Collection<Integer> precios;

    public CarritoDeLaCompra(Collection<Integer> precios) {

        this.precios = precios;
    }

    public int calcularPrecioTotal() {
        int precioTotal = 0;
        for(Integer precio : precios){
        	precioTotal += precio;
        }
        return precioTotal;
    }

    public int contarNumeroProductos() {
        return precios.size();
    }
    
    //En esta usamos expresion lambda para convertir los valores a enteros.
    public int calcularPrecioTotalLambda() {        	
	    int precioTotal = this.precios.stream().mapToInt(precio -> precio.intValue()).sum();
	    LOGGER.info("Precio total Lambda : " + precioTotal);    
        return precioTotal;
    }
    
    //En esta usamos referencia a metodo para convertir los valores a enteros.
    public int calcularPrecioTotalRefMethod() {
        int precioTotal = this.precios.stream().mapToInt(Integer::intValue).sum();
        LOGGER.info("Precio total Referencia: " + precioTotal);    
        return precioTotal;
    }
    
    
    public long calcularDescuentoTotal(int cantidadConDescuento){
        long descuentoTotal = 0;
        for(Integer precio : precios){
            if(precio >= cantidadConDescuento){
            	//El resultado de cada operacion es 5 y como hemos registrado 20 articulos
            	//el resultado final es 100;
                descuentoTotal += (cantidadConDescuento*5)/100;
            }
        }
        LOGGER.info("Descuento total: " + descuentoTotal);        
        return descuentoTotal;
    }
    
    public long calcularDescuentoTotalLambda(int cantidadConDescuento){
        long descuentoTotal = 0;
        Long numeroDeDescuentos  = this.precios.stream()
                                               .filter(precio -> precio.intValue() >= cantidadConDescuento)
                                               .count();
        descuentoTotal = (cantidadConDescuento*5/100)*numeroDeDescuentos;
        return descuentoTotal;
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
    
    
    public static void main(String[] args) {
    	BasicConfigurator.configure();
        LOGGER.trace("Log level trace");
        LOGGER.debug("Log level debug");
        LOGGER.info("Log level info");
        LOGGER.warn("Log level warn");
        LOGGER.error("Log level error");
        LOGGER.fatal("Log level fatal");
    }        
    
}