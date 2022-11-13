package edu.javeriana.entidades;
import java.time.LocalDate;
import java.util.List;

public class Obra {

    private boolean estado;
    public void setEstado(boolean estado) {
		this.estado = estado;
	}
	private long codigoObra;
    private String titulo;
    private LocalDate fecha;
    private float precioRef;
    private String dimensiones;
    private String Artista;

    public Obra()
    {
        this.codigoObra = 0;
        this.titulo="";
        this.fecha=null;
        this.precioRef = 0;
        this.dimensiones="";
        this.Artista ="";
    }

    public Obra(long o, String y, LocalDate date, float precio, String dime, String artis)
    {
        this.codigoObra = o;
        this.titulo=y;
        this.fecha=date;
        this.precioRef = precio;
        this.dimensiones= dime;
        this.Artista = artis;
        estado = true;
    }

    public boolean EvaluacionCodigo(List<Obra> actual, Long cod)
    {
        if(Long.toString(cod).length() != 7)
        {
            System.out.println("-----El codigo de la obra no es valido, no se puede insertar la obra-----");
            return false;
        }

        for(int y=0; y<actual.size(); y++)
        {
            if(cod==actual.get(y).getCodigoObra())
            {
                System.out.println("-----La obra ya existe, no se puede insertar la obra-----");
                return false;
            }
        }

        return true;
    }

    public void setCodigoObra(Long o) { this.codigoObra = o;}
    public void setTitulo(String news)
    {
        this.titulo = news;
    }

    public void setFecha(LocalDate news)
    {
        this.fecha = news;
    }

    public void setPrecioRef(float news)
    {
        this.precioRef = news;
    }

    public void setDimensiones(String news)
    {
        this.dimensiones = news;
    }
    public void setArtista(String news)
    {
        this.Artista = news;
    }
    public Long getCodigoObra()
    {
        return this.codigoObra;
    }
    public String getTitulo()
    {
        return this.titulo;
    }
    public LocalDate getFecha()
    {
        return this.fecha;
    }
    public float getPrecioRef()
    {
        return this.precioRef;
    }
    public String getDimensiones()
    {
        return this.dimensiones;
    }
    public String getArtista()
    {
        return this.Artista;
    }
    public boolean getEstado(){ return this.estado;}



}

