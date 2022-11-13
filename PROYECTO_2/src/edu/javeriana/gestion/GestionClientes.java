package edu.javeriana.gestion;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.javeriana.entidades.Cliente;

public class GestionClientes {

    public List<Cliente> CrearLista( )
    {
        int ia;
        long cod, TID, telefono;
        String nom, aph, direcc;

        List<Cliente> lista = new LinkedList<>();

        Scanner scanner = new Scanner (System.in);

        System.out.println("BIENVENIDO DE NUEVO...DIGANOS ¿Cuántos clientes hay en galería?");
        ia = scanner.nextInt();

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


            Cliente numerosos = new Cliente(cod, TID, nom, aph, direcc, telefono);
            lista.add(numerosos);

        }

      return lista;
    }

    public void InsertarnuevoCliente( List<Cliente> actuales)
    {
        long cod, TID, telefono;
        String nom, aph, direcc;
        boolean hy=false;

        Scanner scanner = new Scanner (System.in);

        Cliente ab = null;
        GestionObras ff = null;
        System.out.println(" Vamos a Agregar una nuevo cliente a la lista... Escriba sus datos");
        System.out.println(" Codigo del Cliente: ");
        cod = scanner.nextLong();

        for(int u=0; u<actuales.size(); u++)
        {
            if(cod== actuales.get(u).getCodigoCliente())
                hy=true;
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

            ab = new Cliente(cod, TID, nom, aph, direcc, telefono);
            actuales.add(ab);
        }else if(hy==true)
                System.out.println("-----La obra ya existe, no se puede insertar la obra-----");


    }
    public void Modificar(List<Cliente> mod)
    {
        int ans, yu;
        long i, cod, TID, telefono;
        String nom, aph, direcc;
        boolean jj = false;
        boolean hh = false;

        Scanner scanner = new Scanner (System.in);

        System.out.println("¿Cuál Cliente? ::: (Diga su codigo)");
        i = scanner.nextLong();
        for(yu =0; yu< mod.size(); yu++)
        {
            if(i==mod.get(yu).getCodigoCliente())
                jj=true;
        }

        if(jj==true) {
            System.out.println("¿Qué quiere modificar? ::: (1. Codigo del Cliente 2. cedula 3. Nombre 4. Apellidos 5. Dirección de Entrega 6. Telefono)");
            ans = scanner.nextInt();
            for (int u = 0; u < mod.toArray().length; u++) {
                if (u == yu) {
                    if (ans == 1) {
                        System.out.println("Escriba el nuevo valor");
                        cod = scanner.nextLong();
                        for(int g =0; g< mod.size(); g++)
                        {
                            if(cod==mod.get(g).getCodigoCliente())
                                hh=true;
                        }
                        if(hh==true)
                            mod.get(u).setCodigoCliente(cod);
                        else if(hh==false)
                            System.out.println("El codigo ya existe, por ello no se pudo modificar el codigo" );

                    }
                    if (ans == 2) {
                        System.out.println("Escriba el nuevo valor");
                        TID = scanner.nextLong();
                        mod.get(u).setCedula(TID);
                    }
                    if (ans == 3) {
                        System.out.println("Escriba el nuevo Nombre");
                        nom = scanner.next();
                        mod.get(u).setNombre(nom);
                    }
                    if (ans == 4) {
                        System.out.println("Escriba los Nuevos Apellidos");
                        aph = scanner.next();
                        mod.get(u).setApellidos(aph);
                    }
                    if (ans == 5) {
                        System.out.println("Escriba el nuevo valor");
                        direcc = scanner.next();
                        mod.get(u).setDireccionEntrega(direcc);
                    }
                    if (ans == 6) {
                        System.out.println("Escriba el nuevo valor");
                        telefono = scanner.nextLong();
                        mod.get(u).setTelefono(telefono);
                    }

                }
            }
        } else if(jj==false)
            System.out.println("No se pudo modificar nada pues el cliente con codigo " + i +"no existe" );

    }
    public void Eliminar(List<Cliente> gg)
    {
        int yu;
        Long i;
        boolean jj = false;

        Scanner scanner = new Scanner (System.in);

        System.out.println("¿Cuál Cliente va a eliminar? ::: (Diga su posición)");
        i = scanner.nextLong();

        for(yu =0; yu< gg.size(); yu++)
        {
            if(i==gg.get(yu).getCodigoCliente())
                jj=true;
        }
        if(jj==true)
        {
            if(gg.get(yu).getEstado()==true)
                gg.remove(yu);
        } else if(jj==false)
            System.out.println("No se pudo eliminar nada pues el cliente con codigo " + i +"no existe" );

    }


}
