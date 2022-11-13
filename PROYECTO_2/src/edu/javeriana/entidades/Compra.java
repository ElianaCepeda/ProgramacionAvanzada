package edu.javeriana.entidades;
import java.time.LocalDate;

public class Compra {
    private long codigoCompra;
    private LocalDate fecha;
    private boolean pagado;
    
    private Obra obra;
    private Cliente cliente;
    
    
	public Obra getObra() {
		return obra;
	}


	public void setObra(Obra obra) {
		this.obra = obra;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Compra(long codigoCompra, Obra obra, Cliente cliente, LocalDate fecha, boolean pagado) {
		super();
		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
		this.cliente = cliente;
		this.obra = obra;
	}
	
	
	public long getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
    
    
}
