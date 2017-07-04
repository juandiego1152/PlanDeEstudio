package com.proyecto.java8.CompletableFurute;

public class Sleep {


	public static void sleepSeconds(int i){
		try{
			int finalx = i * 1000;
			int x = 0;
			while (x < finalx) {
				System.out.println(x);
				Thread.sleep(1000);
				x = x + 1000;			 
			}		
		}catch(InterruptedException e){	}		
	}
}
