package edu.javeriana.entidades;
import java.time.LocalDate;

public class Compra {
    private long codigoCompra;
    private LocalDate fecha;
    private boolean pagado;
    
    private Obra compraObra;
    private Cliente compraCliente;
    
    
	public Obra getObra() {
		return compraObra;
	}


	public void setCompraObra(Obra obra) {
		this.compraObra = obra;
	}


	public Cliente getCompraCliente() {
		return compraCliente;
	}


	public void setCliente(Cliente cliente) {
		this.compraCliente = cliente;
	}


	public Compra(long codigoCompra, Obra obra, Cliente cliente, LocalDate fecha, boolean pagado) {
		super();
		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
		this.compraCliente = cliente;
		this.compraObra = obra;
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
