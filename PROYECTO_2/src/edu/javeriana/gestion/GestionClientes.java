package edu.javeriana.gestion;

import java.util.List;
import java.util.Scanner;

import edu.javeriana.entidades.Cliente;

public class GestionClientes {
	
	private ControladorGaleria galeria;

	public GestionClientes (ControladorGaleria galeriaPadre)
	{
		this.galeria = galeriaPadre;
	}

    public List<Cliente> CrearLista( )
    {
        int ia = -1;
        long cod, TID, telefono;
        String nom, aph, direcc;

        List<Cliente> lista = galeria.getListaClientes();

        try (Scanner scanner = new Scanner (System.in)) {
			System.out.println("BIENVENIDO DE NUEVO...DIGANOS ¿Cuántos clientes hay en galería?");
			ia = scanner.nextInt();
			while(ia < 1 )
			{
			    System.out.println("El numero de clientes no puede ser menor que 1 ... DIGANOS ¿Cuántos clientes hay en galería?");
			    ia = scanner.nextInt();
			}
			for(int y=0; y<ia; y++)
			{
			    System.out.println(" Vamos a llenar la lista... Escriba los Datos de TODOS LOS CLIENTES");
			    System.out.println(" Codigo del Cliente");
			    cod = scanner.nextLong();
			    System.out.println("Cedula");
			    TID = scanner.nextLong();
			    System.out.println("Nombres");
			    nom = scanner.next();
			    System.out.println("Apellidos");
			    aph = scanner.next();
			    System.out.println("Dirección de entrega");
			    direcc = scanner.next();
			    System.out.println("Telefonos");
			    telefono = scanner.nextLong();
			    
			    
			    Cliente numerosos = new Cliente(cod, TID, nom, aph, direcc, telefono,true, null);
			    lista.add(numerosos);

			}
		}

        return lista;
    }

    public void InsertarNuevoCliente()
    {
        long cod, TID, telefono;
        String nom, aph, direcc;
        boolean hy=true;
        List<Cliente> actuales = galeria.getListaClientes();

        try (Scanner scanner = new Scanner (System.in)) {
			Cliente ab = null;
			System.out.println(" Vamos a Agregar una nuevo cliente a la lista... Escriba sus datos");
			System.out.println(" Codigo del Cliente: ");
			cod = scanner.nextLong();
			
			while(hy==true)
			{
				hy=false;
			    for(int u=0; u<actuales.size(); u++)
			    {
			        if(cod== actuales.get(u).getCodigoCliente())
			            hy=true;
			    }
			    if(hy)
			        System.out.println("-----El cliente no existe, por favor digite nuevamente el codigo de cliente: -----");
			}
			if(hy==false)
			{
			    System.out.println(" Codigo del Cliente");
			    cod = scanner.nextLong();
			    System.out.println("Cedula");
			    TID = scanner.nextLong();
			    System.out.println("Nombres");
			    nom = scanner.next();
			    System.out.println("Apellidos");
			    aph = scanner.next();
			    System.out.println("Dirección de entrega");
			    direcc = scanner.next();
			    System.out.println("Telefonos");
			    telefono = scanner.nextLong();

			    ab = new Cliente(cod, TID, nom, aph, direcc, telefono, true, null);
			    actuales.add(ab);
			}
		}

    }
    public void Modificar()
    {
        List<Cliente> mod = galeria.getListaClientes();

        int ans, yu;
        long i, cod, TID, telefono;
        String nom, aph, direcc;
        boolean jj = false;
        boolean hh = false;
        Cliente clienteEncontrado = null;

        Scanner scanner = new Scanner (System.in);
        while(jj==false)
        {
        	jj=false;
	        System.out.println("¿Cuál Cliente? ::: (Diga su codigo)");
	        i = scanner.nextLong();
	        for(yu =0; yu< mod.size(); yu++)
	        {
	            if(i==mod.get(yu).getCodigoCliente())
	            {
	                jj=true;
	                clienteEncontrado = mod.get(yu);
	            }
	        }
	        if(jj==false)
	            System.out.println("No se pudo modificar nada pues el cliente con codigo " + i +"no existe" );
        }
        if(jj==true) {
            System.out.println("¿Qué quiere modificar? ::: (1. Codigo del Cliente 2. cedula 3. Nombre 4. Apellidos 5. Dirección de Entrega 6. Telefono)");
            ans = scanner.nextInt();
            if (ans == 1)
            {
                System.out.println("Escriba el nuevo valor");
                cod = scanner.nextLong();
                for(int g =0; g< mod.size(); g++)
                {
                    if(cod==mod.get(g).getCodigoCliente())
                        hh=true;
                }
                if(hh==true)
                    clienteEncontrado.setCodigoCliente(cod);
                else if(hh==false)
                    System.out.println("El codigo ya existe, por ello no se pudo modificar el codigo" );
            }
            if (ans == 2) {
                System.out.println("Escriba el nuevo valor");
                TID = scanner.nextLong();
                clienteEncontrado.setCedula(TID);
            }
            if (ans == 3) {
                System.out.println("Escriba el nuevo Nombre");
                nom = scanner.next();
                clienteEncontrado.setNombre(nom);
            }
            if (ans == 4) {
                System.out.println("Escriba los Nuevos Apellidos");
                aph = scanner.next();
                clienteEncontrado.setApellidos(aph);
            }
            if (ans == 5) {
                System.out.println("Escriba el nuevo valor");
                direcc = scanner.next();
                clienteEncontrado.setDireccionEntrega(direcc);
            }
            if (ans == 6) {
                System.out.println("Escriba el nuevo valor");
                telefono = scanner.nextLong();
                clienteEncontrado.setTelefono(telefono);
            }
        }
    }
    public void Eliminar()
    {
        int yu;
        Long i;
        boolean jj = false;
        List<Cliente> gg = galeria.getListaClientes();

        Scanner scanner = new Scanner (System.in);

        while(jj==false)
        {
        	jj=false;
	        System.out.println("¿Cuál Cliente va a eliminar? ::: (Diga su codigo)");
	        i = scanner.nextLong();
	        for(yu =0; yu< gg.size(); yu++)
	        {
	            if(i==gg.get(yu).getCodigoCliente())
	            {
	                jj=true;
	                gg.remove(yu);
	            }
	        }
	        if(jj==false)
	            System.out.println("No se pudo eliminar nada pues el cliente con codigo " + i +"no existe" );
        }

    }

	public Cliente buscarClientePorCodigo(Long codCliente) {
		
		List<Cliente> lista = galeria.getListaClientes();
		Cliente clienteEncontrado = null;
        for(int yu = 0; yu< lista.size(); yu++)
        {
            if(codCliente==lista.get(yu).getCodigoCliente())
            {
                clienteEncontrado = lista.get(yu);
            }
        }
		return clienteEncontrado;
	}


}
