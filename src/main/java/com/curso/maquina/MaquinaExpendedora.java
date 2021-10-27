package com.curso.maquina;

public class MaquinaExpendedora {
	
	//informe
	private double recaudacion;
	private int cantidadVendida;
	
	private double cambios;
	private Refresco refresco;
	
	public MaquinaExpendedora(Refresco refresco, 
			double cambiosIni) {
		this.recaudacion = 0.0;
		this.recaudacion = 0;
		this.cambios = cambiosIni;
		this.refresco = refresco;
	}
	/**
	 * Metodo que vende 1 refresco. Recibe el dinero
	 * que introduce el usuario en la maquina
	 * y devuelve el cambio. 
	 * Si no hay stock devuelve -1
	 * si no hay cambios devuelve -2
	 * si no ha introducido el importe suficientes -3
	 * @param dineroIng
	 * @return
	 */
	public double vender(double dineroIng){
		//validar datos entrada
		//PENDIENTE
		//validar stock
		if(this.refresco.estaAgotado()) {
			return -1;
		}
		//validar si hay cambio suficiente
		double cambioNec = dineroIng - this.refresco.getPrecioUnidad();
		if(cambioNec < 0 ) {
			return -3; //no dinero suficiente
		}
		if(cambioNec > this.cambios) {
			return -2;
		}
		
		//todo ok
		this.cantidadVendida ++;
		this.recaudacion += this.refresco.getPrecioUnidad();
		this.refresco.entregar(); //resta 1 al stock ref
		this.cambios += this.refresco.getPrecioUnidad(); 
		
		return cambioNec;
	}
	
	
	public void setRefresco(Refresco refresco) {
		this.refresco = refresco;
	}
	
	public double getCambios() {
		return cambios;
	}
	public double getRecaudacion() {
		return recaudacion;
	}
	public int getCantidadVendida() {
		return cantidadVendida;
	}

}
