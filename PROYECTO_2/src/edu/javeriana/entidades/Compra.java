package edu.javeriana.entidades;
import java.time.LocalDate;

public class Compra {
    private long codigoCompra;
    private LocalDate fecha;
    private boolean pagado;
    
    
	public Compra(long codigoCompra, LocalDate fecha, boolean pagado) {
		super();
		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
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
