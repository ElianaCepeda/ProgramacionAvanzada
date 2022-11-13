package edu.javeriana.excepciones;

public class GaleriaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248928732760224563L;

	public GaleriaException(String string) {
		super();
		System.out.println("ERROR, compra no encontrada");
	}

}
