package edu.javeriana.control;

import java.util.Scanner;

import edu.javeriana.gestion.ControladorGaleria;

public class PantallaGaleria {

	private static ControladorGaleria galeria;

	public static void main(String[] args) {
    	String option;
    	boolean salir = false;
    	galeria = new ControladorGaleria();
    	galeria.VerListaObrasDisponibles();
        try (Scanner scanner = new Scanner (System.in)) {
        	while(salir == false)
        	{
	        	System.out.println("MENU PRINCIPAL");
				option = scanner.next();
				if(option.equalsIgnoreCase("Exit"))
					salir = true;
        	}
        }
	}

}
