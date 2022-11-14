package edu.javeriana.gestion;

import java.util.*;
import java.util.Scanner;
import edu.javeriana.entidades.Artista;
import edu.javeriana.entidades.Cliente;
import edu.javeriana.entidades.Compra;
import edu.javeriana.entidades.Obra;
import edu.javeriana.excepciones.GaleriaException;

import java.io.IOException;
import java.time.LocalDate;

public class ControladorGaleria {

	private List<Obra> listaObras;
	private List<Artista> listaArtistias;
	private List<Cliente> listaClientes;
	private List<Compra> compras;

	public ControladorGaleria() {
		// TODO: Llenar las clases con datos iniciales para poder probar el programa, preferiblemente desde un archivo o por medio de codigo en lugar de preguntarlo a los usuarios
		listaObras = new LinkedList<Obra>();
		listaArtistias = new LinkedList<Artista>();
		listaClientes = new LinkedList<Cliente>();
		compras = new LinkedList<Compra>();
		GestionObras gestionObras = new GestionObras(this);
		gestionObras.CrearArtista();
		gestionObras.LlenarListaObras();
		GestionClientes gestionCliente = new GestionClientes(this);
		gestionCliente.CrearLista();
	}

	public void VerListaObrasDisponibles() {
		for (int y = 0; y < listaObras.size(); y++) {
			if (listaObras.get(y).getEstado() == true) {
				System.out.println("-------------------");
				System.out.println("Obra " + (y + 1) + ":");
				System.out.println("Codigo de la Obra: " + listaObras.get(y).getCodigoObra());
				System.out.println("Titulo : " + listaObras.get(y).getTitulo());
				System.out.println("Fecha : " + listaObras.get(y).getFecha());
				System.out.println("Precio de Referencia : " + listaObras.get(y).getPrecioRef());
				System.out.println("Dimensiones: " + listaObras.get(y).getDimensiones());
			}

		}
	}

	public void VerListaClientes() {
	
		for (int p = 0; p < listaClientes.size(); p++) {
			System.out.println("-------------------");
			System.out.println("Cliente " + (p + 1) + ":");
			System.out.println("Nombre: " + listaClientes.get(p).getNombre());
			System.out.println("Apellido : " + listaClientes.get(p).getApellidos());
			System.out.println("Dirección : " + listaClientes.get(p).getDireccionEntrega());
			System.out.println("Telefono : " + listaClientes.get(p).getTelefono());
		}
	}
	
	public Cliente BuscarCliente() throws IOException {
		Long codCliente;
		Cliente clienteEncontrado;
		GestionClientes gestionCliente = new GestionClientes(this);
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Escriba el codigo del cliente");
			codCliente = scanner.nextLong();
			clienteEncontrado = gestionCliente.buscarClientePorCodigo(codCliente);
		}
		return clienteEncontrado;
	}

	public Obra BuscarObra() throws IOException {
		int dia, mes, año;
		String ans, busca;
		LocalDate uy;
		long buscaCod;
		Obra obraEncontrada = null;
		GestionObras gestionObras = new GestionObras(this);

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("HOLA...POR DONDE QUIERES BUSCAR LA OBRA(T para titulo, A para artista o I por fecha)");
			ans = scanner.next();

			if (ans.equalsIgnoreCase("T")) {
				System.out.println("Escriba el titulo que quiera buscar");
				busca = scanner.next();
				obraEncontrada= gestionObras.BuscaporTitulo( busca);
			} else if (ans.equalsIgnoreCase("A")) {
				System.out.println("Escriba el codigo del Artista que quiera buscar");
				buscaCod = scanner.nextLong();
				obraEncontrada = gestionObras.BuscaporArtista(buscaCod);
			} else if (ans.equalsIgnoreCase("I")) {
				System.out.println("Escriba la fecha que quiera buscar...(1. año - 2.mes - 3.dia)");
				año = scanner.nextInt();
				mes = scanner.nextInt();
				dia = scanner.nextInt();
				uy = LocalDate.of(año, mes, dia);
				obraEncontrada = gestionObras.BuscaporFecha(uy);
			} else
				System.out.println("LA OPCIÓN NO EXISTE");
		}
		return obraEncontrada;
	}

	public void AgregarObra() {
		GestionObras gestionObras = new GestionObras(this);
		gestionObras.InsertarNuevaObra();
	}

	public void MenuListaClientes() throws IOException {
		GestionClientes gestionCliente = new GestionClientes(this);

		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans1;

			System.out.println("¿Va a modificar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				gestionCliente.Modificar();
			System.out.println("¿Va a eliminar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				gestionCliente.Eliminar();
		}

	}

	public void MenuListaObras() throws IOException {
		GestionObras gestionObras = new GestionObras(this);

		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans;
			System.out.println("¿Va a modificar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				gestionObras.Modificar();
			System.out.println("¿Va a eliminar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				gestionObras.Eliminar();
		}
	
	}
	
	private long ultimaCompra()
	{
		long ultimacompra = 0;
		for (int p = 0; p < compras.size(); p++) {
			if(compras.get(p).getCodigoCompra() > ultimacompra)
				ultimacompra = compras.get(p).getCodigoCompra();
		}
		return ultimacompra;
	}
	
	// Resuelve el punto 11 hacer compra
	public void ComprarObra()
	{
		Obra obraComprar = null;
		Cliente comprador = null;
		Compra compra = null;
		long codigoCompra;
		while(obraComprar == null)
		{
			try {
				obraComprar = BuscarObra();
			} catch (IOException e) {
				System.out.println("La obra a comprar no pudo ser encontrada, intentelo nuevamente, por favor.");
			}
			if(obraComprar.getEstado() == false)
			{
				System.out.println("La obra a comprar no esta disponible, intentelo nuevamente, por favor.");	
			}
		}
		while(comprador == null)
		{
			try {
				comprador = BuscarCliente();
			} catch (IOException e) {
				System.out.println("El cliente no pudo ser encontrado, intentelo nuevamente, por favor.");
			}
		}
		codigoCompra = ultimaCompra()+1;
		compra = new Compra(codigoCompra,obraComprar, comprador, LocalDate.now(),true);
		obraComprar.setEstado(false);
		compras.add(compra);
		System.out.println("Su compra fue creada con codigo: " + codigoCompra);

	}
	
	// Resuelve el punto 12, Eliminar compra
	public void eliminarCompra() throws GaleriaException
	{
		long cod;
		String respuesta;
		boolean encontrado = false;
		System.out.println("Por favor digite el numero de compra que desea eliminar.");
        try (Scanner scanner = new Scanner (System.in)) {
			cod = scanner.nextLong();
			for (int p = 0; p < compras.size(); p++)
			{
				if(compras.get(p).getCodigoCompra()==cod)
				{
					System.out.println("Esta compra fue encontrada: " + compras.get(p).toString());
					System.out.println("Confirme que desea eliminar esta compra escribiendo SI");
			        respuesta = scanner.next();
			        if(respuesta.equalsIgnoreCase("si"))
			        {
						compras.get(p).getObra().setEstado(true);
						compras.remove(p);
						encontrado = true;
			        }else
			        	throw new GaleriaException("La compra no fue eliminada por desición del usuario.");
				}
			}
		}
        if(encontrado == false)
			throw new GaleriaException("La compra no fue encontrada");
	}

	public List<Obra> getListaObras() {
		return listaObras;
	}

	public void setListaObras(List<Obra> listaObras) {
		this.listaObras = listaObras;
	}

	public List<Artista> getListaArtistias() {
		return listaArtistias;
	}

	public void setListaArtistias(List<Artista> listaArtistias) {
		this.listaArtistias = listaArtistias;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
