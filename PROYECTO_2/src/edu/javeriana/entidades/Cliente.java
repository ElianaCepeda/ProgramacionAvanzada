package edu.javeriana.entidades;
import java.util.List;
public class Cliente {
    private long codigoCliente;
    private long cedula;
    private String nombre;
    private String Apellidos;
    private String direccionEntrega;
    private long telefono;
    private boolean estado;
    private List<Obra> carritodeCompras;
    
    
	public Cliente(long codigoCliente, long cedula, String nombre, String apellidos, String direccionEntrega,
			long telefono, boolean estado, List<Obra> carritodeCompras) {
		super();
		this.codigoCliente = codigoCliente;
		this.cedula = cedula;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.direccionEntrega = direccionEntrega;
		this.telefono = telefono;
		this.estado = estado;
		this.carritodeCompras = carritodeCompras;
	}
	

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Obra> getCarritodeCompras() {
		return carritodeCompras;
	}

	public void setCarritodeCompras(List<Obra> carritodeCompras) {
		this.carritodeCompras = carritodeCompras;
	}
	
	


}
