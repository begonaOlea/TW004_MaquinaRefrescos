package com.curso.maquina;

public class CambiosException extends Exception {

	 private double importeFalta;

	public CambiosException(double importeFalta, String msg) {
		super(msg);
		this.importeFalta = importeFalta;
	}
	 
	 
	public CambiosException(String msg) {
		super(msg);
	}
	
}
