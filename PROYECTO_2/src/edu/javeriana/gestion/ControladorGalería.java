package edu.javeriana.gestion;

import java.util.*;
import java.util.Scanner;
import edu.javeriana.entidades.Artista;
import edu.javeriana.entidades.Cliente;
import edu.javeriana.entidades.Obra;
import java.io.IOException;
import java.time.LocalDate;

public class ControladorGalería {

	private List<Obra> conObr = new LinkedList<>();
	private List<Artista> artist = new LinkedList<>();
	public GestionObras nop = new GestionObras();
	private List<Cliente> conclien = new LinkedList<>();
	public GestionClientes noppi = new GestionClientes();

	public ControladorGalería() {
		this.conObr = nop.CrearLista();
		nop.CrearArtista(this.artist);
		this.conclien = noppi.CrearLista();
	}

	public void ListaObras() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans;
			System.out.println("¿Va a modificar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				nop.Modificar(this.conObr);
			System.out.println("¿Va a eliminar alguna obra?");
			ans = scanner.nextBoolean();
			if (ans == true)
				nop.Eliminar(this.conObr);
		}

	}

	public void verlistaObrasDisponibles() {
		for (int y = 0; y < conObr.size(); y++) {
			if (conObr.get(y).estado == true) {
				System.out.println("-------------------");
				System.out.println("Obra " + (y + 1) + ":");
				System.out.println("Codigo de la Obra: " + conObr.get(y).getCodigoObra());
				System.out.println("Titulo : " + conObr.get(y).getTitulo());
				System.out.println("Fecha : " + conObr.get(y).getFecha());
				System.out.println("Precio de Referencia : " + conObr.get(y).getPrecioRef());
				System.out.println("Dimensiones: " + conObr.get(y).getDimensiones());
			}

		}
	}

	public void BuscarObra() throws IOException {
		int dia, mes, año;
		String ans, busca;
		LocalDate uy;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("HOLA...POR DONDE QUIERES BUSCAR LA OBRA(T para titulo, A para artista o I por fecha)");
			ans = scanner.next();

			if (ans.equalsIgnoreCase("T")) {
				System.out.println("Escriba el titulo que quiera buscar");
				busca = scanner.next();
				nop.BuscaporTitulo(conObr, busca);
			} else if (ans.equalsIgnoreCase("A")) {
				System.out.println("Escriba el Artista que quiera buscar");
				busca = scanner.next();
				nop.BuscaporArtista(conObr, busca);
			} else if (ans.equalsIgnoreCase("I")) {
				System.out.println("Escriba la fecha que quiera buscar...(1. año - 2.mes - 3.dia)");
				año = scanner.nextInt();
				mes = scanner.nextInt();
				dia = scanner.nextInt();
				uy = LocalDate.of(año, mes, dia);
				nop.BuscaporFecha(conObr, uy);
			} else
				System.out.println("LA OPCIÓN NO EXISTE");
		}
	}

	public void AgregarObra() {
		nop.InsertarnuevaObra(conObr, artist);
	}

	public void ListaClientes() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean ans1;

			System.out.println("¿Va a modificar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				noppi.Modificar(this.conclien);
			System.out.println("¿Va a eliminar alguna obra?");
			ans1 = scanner.nextBoolean();
			if (ans1 == true)
				noppi.Eliminar(this.conclien);
		}

	}

	public void verListaClientes() {

		for (int p = 0; p < conclien.size(); p++) {
			System.out.println("-------------------");
			System.out.println("Cliente " + (p + 1) + ":");
			System.out.println("Nombre: " + conclien.get(p).getNombre());
			System.out.println("Apellido : " + conclien.get(p).getApellidos());
			System.out.println("Dirección : " + conclien.get(p).getDireccionEntrega());
			System.out.println("Telefono : " + conclien.get(p).getTelefono());
		}
	}

}
