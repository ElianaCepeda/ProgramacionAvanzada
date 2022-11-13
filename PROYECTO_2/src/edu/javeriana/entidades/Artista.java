package edu.javeriana.entidades;

import java.time.LocalDate;

public class Artista {

	private long cedula;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private long telefono;
	private long codigoArtista;

	public Artista(long codigoArtista, long cedula, String nombre, String apellidos, LocalDate fechaNacimiento, long telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.codigoArtista = codigoArtista;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public long getCodigoArtista() {
		return codigoArtista;
	}

	public void setCodigoArtista(long codigoArtista) {
		this.codigoArtista = codigoArtista;
	}

}
