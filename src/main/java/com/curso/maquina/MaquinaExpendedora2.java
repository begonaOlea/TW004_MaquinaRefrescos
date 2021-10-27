package com.curso.maquina;

public class MaquinaExpendedora2 {
	
	//informe
	private double recaudacion;
	private int cantidadVendida;
	
	private double cambios;
	private Refresco[] refrescos; //3 
	
	public MaquinaExpendedora2(Refresco[] refrescos, 
			double cambiosIni) {
		this.recaudacion = 0.0;
		this.recaudacion = 0;
		this.cambios = cambiosIni;
		this.refrescos = refrescos ;
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
	public double vender(double dineroIng, int posicion){
		//validar datos entrada
		//PENDIENTE
		
		//validar stock
		if(this.refrescos[posicion].estaAgotado()) {
			return -1;
		}
		//validar si hay cambio suficiente
		double cambioNec = dineroIng - this.refrescos[posicion].getPrecioUnidad();
		if(cambioNec < 0 ) {
			return -3; //no dinero suficiente
		}
		if(cambioNec > this.cambios) {
			return -2;
		}
		
		//todo ok
		this.cantidadVendida ++;
		this.recaudacion += this.refrescos[posicion].getPrecioUnidad();
		this.refrescos[posicion].entregar(); //resta 1 al stock ref
		this.cambios += this.refrescos[posicion].getPrecioUnidad(); 
		
		return cambioNec;
	}
	
	
	public void reponerRefresco(Refresco refresco, int posicion) {
		this.refrescos[posicion] = refresco;
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
