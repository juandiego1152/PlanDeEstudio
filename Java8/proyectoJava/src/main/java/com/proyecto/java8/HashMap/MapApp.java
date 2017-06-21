package com.proyecto.java8.HashMap;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapApp {
	private Map<Integer, String> map;
	
	public void poblar(){
		map = new HashMap<>();
		map.put(1, "Juan Diego");
		map.put(2, "Sebastian");
		map.put(3, "Jose Ignacio");
		map.put(4, "Adrian Maria");
	}
	
	public void imprimri_V7(){
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println("LLave " + e.getKey() + "Valor " + e.getValue());
		}
	}

	public void imprimir_V8(){
		//map.forEach((k,v) -> System.out.println("LLave " + k + " Valor " + v));
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void insertarSiAusente(){
		map.putIfAbsent(5, "Karine");
	}
	
	public void operarSiPresente(){
		map.computeIfPresent(3, (k,v)-> k + v);
		System.out.println(map.get(3));
	}
	
	public void recolectar(){
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e->e.getValue().contains("J"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		mapaRecolectado.forEach((k,v) -> System.out.println("LLave " + k + " Valor " + v));
	}
	
	public void obtenerOrPredeterminado(){
		String valor = map.getOrDefault(6, "Valor por defecto");
		System.out.println(valor);
	}
	
	public static void main(String[] args) {
		MapApp app = new MapApp();
		app.poblar();
		//app.insertarSiAusente();
		//app.imprimir_V8();
		//app.operarSiPresente();
		//app.obtenerOrPredeterminado();
		app.recolectar();
	}
}
