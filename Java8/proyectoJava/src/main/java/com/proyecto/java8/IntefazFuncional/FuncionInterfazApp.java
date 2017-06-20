package com.proyecto.java8.IntefazFuncional;

public class FuncionInterfazApp {

	public double operar(double x, double y){
		operacion op = (n1,n2) -> n1 + n2;
		return op.calcular(x, y);
	}
	
	public static void main(String[] args) {
		FuncionInterfazApp app = new FuncionInterfazApp();
		double resultado = app.operar(2, 3);
		System.out.println("Resultado: " + resultado);
	}
}
