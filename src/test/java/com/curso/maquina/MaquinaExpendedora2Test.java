package com.curso.maquina;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaquinaExpendedora2Test {

	
	private MaquinaExpendedora2 me;


	@Test
	public void testVenderSinStok() {
	
		Refresco[]  r = {
				new Refresco("cola", 80,0),
				new Refresco("agua", 50,10),
				new Refresco("zumo", 100,10),
				
		};
		me = new MaquinaExpendedora2(r, 10); 
		
		double espero = -1.0;
		double cambios = me.vender(100,0);
		
		if(espero != cambios)
				fail("Error. Debe devolver -1");
	}
	
	@Test
	public void testVenderRefSinCambiosSuficientes() {
		// DATOS ENTRADA PRUEBA
		// refresco cola 80 centimos
		// maquina de ref  cambios 10
		// el usuairo compra una refesco de cola e introd 100 centimos
		Refresco[]  r = {
				new Refresco("cola", 80,10),
				new Refresco("agua", 50,10),
				new Refresco("zumo", 100,10),
				
		};
		me = new MaquinaExpendedora2(r, 10); //tiene 10 cts de cambios
		
		//DATOS ESPERADO 
		double espero = -2.0;
		//LLAMO AL método
		double cambios = me.vender(100,0);
		
		if(espero != cambios)
				fail("Error. Debe devolver -2 de no hay cambios");

	}
	
	
	
	
	@Test
	public void testVenderUnReferscoOK() {
		Refresco[]  r = {
				new Refresco("cola", 80,10),
				new Refresco("agua", 50,10),
				new Refresco("zumo", 100,10),
				
		};
		me = new MaquinaExpendedora2(r, 100); //tiene 10 cts de cambios
		
		//DATOS ESPERADO 
		double espero = 20; 
		double esperoCambiosMaq = 180; // cambios - cambiosDevuelvo + ingreso
		double esperoVenta= 1;
		double esperoRecauda = 80;
		//LLAMO AL método
		double respuesta = me.vender(100,0);
		
		if(respuesta != espero)
				fail("Error. debería devolver 20 cent de cambios" + respuesta);

		if(esperoCambiosMaq != me.getCambios())
			fail("Error. La maquina debería tener 180 cent cambios");
		
		if(esperoRecauda != me.getRecaudacion())
			fail("Error. La recaudación deb ser 80");
		if(esperoVenta != me.getCantidadVendida())
			fail("Error. Deberia indicar  1 ref vendido");

	}
	
	
	
	
	
}
