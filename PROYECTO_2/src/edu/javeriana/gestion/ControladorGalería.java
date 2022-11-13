package edu.javeriana.gestion;

import java.util.*;
import java.util.Scanner;
import edu.javeriana.entidades.Artista;
import edu.javeriana.entidades.Cliente;
import edu.javeriana.entidades.Compra;
import edu.javeriana.entidades.Obra;
import java.io.IOException;
import java.time.LocalDate;

public class ControladorGalería {

	private List<Obra> listaObras = new LinkedList<>();
	private List<Artista> listaArtistias = new LinkedList<>();
	private GestionObras gestionObras = new GestionObras();
	private List<Cliente> listaClientes = new LinkedList<>();
	private GestionClientes gestionCliente = new GestionClientes();
	private List<Compra> compras = new LinkedList<>();

	public ControladorGalería() {
		this.listaObras = gestionObras.CrearLista();
		gestionObras.CrearArtista(this.listaArtistias);
		this.listaClientes = gestionCliente.CrearLista();
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
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Escriba el codigo del cliente");
			codCliente = scanner.nextLong();
			clienteEncontrado = gestionCliente.buscarClientePorCodigo(listaClientes, codCliente);
		}
		return clienteEncontrado;
	}

	public Obra BuscarObra() throws IOException {
		int dia, mes, año;
		String ans, busca;
		LocalDate uy;
		Obra obraEncontrada = null;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("HOLA...POR DONDE QUIERES BUSCAR LA OBRA(T para titulo, A para artista o I por fecha)");
			ans = scanner.next();

			if (ans.equalsIgnoreCase("T")) {
				System.out.println("Escriba el titulo que quiera buscar");
				busca = scanner.next();
				obraEncontrada= gestionObras.BuscaporTitulo(listaObras, busca);
			} else if (ans.equalsIgnoreCase("A")) {
				System.out.println("Escriba el Artista que quiera buscar");
				busca = scanner.next();
				obraEncontrada = gestionObras.BuscaporArtista(listaObras, busca);
			} else if (ans.equalsIgnoreCase("I")) {
				System.out.println("Escriba la fecha que quiera buscar...(1. año - 2.mes - 3.dia)");
				año = scanner.nextInt();
				mes = scanner.nextInt();
				dia = scanner.nextInt();
				uy = LocalDate.of(año, mes, dia);
				obraEncontrada = gestionObras.BuscaporFecha(listaObras, uy);
			} else
				System.out.println("LA OPCIÓN NO EXISTE");
		}
		return obraEncontrada;
	}

	public void AgregarObra() {
		gestionObras.InsertarnuevaObra(listaObras, listaArtistias);
	}

	public void MenuListaClientes() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans1;

			System.out.println("¿Va a modificar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				gestionCliente.Modificar(this.listaClientes);
			System.out.println("¿Va a eliminar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				gestionCliente.Eliminar(this.listaClientes);
		}

	}

	public void MenuListaObras() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans;
			System.out.println("¿Va a modificar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				gestionObras.Modificar(this.listaObras);
			System.out.println("¿Va a eliminar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				gestionObras.Eliminar(this.listaObras);
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
		compra = new Compra(codigoCompra,LocalDate.now(),true);
		obraComprar.setEstado(false);
		compras.add(compra);
		System.out.println("Su compra fue creada con codigo: " + codigoCompra);

	}

}
