package edu.javeriana.gestion;

import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

import edu.javeriana.entidades.Artista;
import edu.javeriana.entidades.Obra;

public class GestionObras {

    public List<Obra> CrearLista( )
    {
        int ia, año, mes, dia;
        long cod;
        String tit, dimen, arts;
        LocalDate fec;
        float precioRef;

        List<Obra> lista = new LinkedList<>();

        Scanner scanner = new Scanner (System.in);

        System.out.println("BIENVENIDO...DIGANOS ¿Cuantas obras existen en galería?");
        ia = scanner.nextInt();

        for(int y=0; y<ia; y++)
        {
            System.out.println(" Vamos a llenar la lista... Escribe los Datos de la Obra");
            System.out.println(" Codigo de la Obra");
            cod = scanner.nextLong();
            System.out.println("Titulo");
            tit = scanner.next();
            System.out.println("Fecha: 1)Año 2)Mes 3)Dia");
            año = scanner.nextInt();
            mes= scanner.nextInt();
            dia = scanner. nextInt();
            fec = LocalDate.of(año, mes, dia);
            System.out.println("Precio de Referencia");
            precioRef = scanner.nextFloat();
            System.out.println("Dimensiones");
            dimen = scanner.next();
            System.out.println("Artista");
            arts = scanner.next();

            Obra num = new Obra(cod, tit, fec, precioRef, dimen, arts);
            lista.add(num);

        }

      return lista;
    }

    public void InsertarnuevaObra( List<Obra> actual, List<Artista> artist)
    {
        int ia, año, mes, dia;
        long cod;
        String tit, dimen, arts;
        LocalDate fec;
        float precioRef;
        boolean hy, ek= true;

        Scanner scanner = new Scanner (System.in);

        Obra ab = null;
        GestionObras ff = null;
        System.out.println(" Vamos a Agregar una nueva obra a la lista... Escribe los Datos de la Obra");
        System.out.println(" Codigo de la Obra");
        cod = scanner.nextLong();

        hy = ab.EvaluacionCodigo(actual, cod);
        if(hy==true)
        {
            System.out.println("Titulo");
            tit = scanner.next();
            System.out.println("Fecha: 1)Año 2)Mes 3)Dia");
            año = scanner.nextInt();
            mes= scanner.nextInt();
            dia = scanner. nextInt();
            fec = LocalDate.of(año, mes, dia);
            System.out.println("Precio de Referencia");
            precioRef = scanner.nextFloat();
            System.out.println("Dimensiones");
            dimen = scanner.next();
            System.out.println("Artista");
            arts = scanner.next();
            for(int h=0; h< artist.size(); h++)
            {
                if(arts == artist.get(h).getNombre())
                    ek=false;
            }
            if(ek==true)
            {
                ff.CrearArtista(artist);
            }

            ab = new Obra(cod, tit, fec, precioRef, dimen, arts);
            actual.add(ab);
        }

    }

    public void Modificar(List<Obra> mod)
    {
        int ans, yu;
        int año, mes, dia;
        long cod, i;
        String tit, dimen, kk;
        LocalDate fec;
        float precioRef;
        boolean gg = true;
        boolean jj = false;

        Scanner scanner = new Scanner (System.in);
        Obra tt= null;

        System.out.println("¿Cuál Obra? ::: (Diga su codigo)");
        i = scanner.nextLong();
        for(yu =0; yu< mod.size(); yu++)
        {
            if(i==mod.get(yu).getCodigoObra())
                jj=true;
        }

        if(jj==false)
        {
            System.out.println("¿Qué quiere modificar? ::: (1. codigoObra 2. titulo 3. Fecha 4. Precio de Referencia 5. Dimensiones 6. Nombre del Artista)");
            ans = scanner.nextInt();
            for(int u=0; u< mod.size(); u++)
            {
                if(u==yu)
                {
                    if(ans==1)
                    {
                        System.out.println("Escriba el nuevo valor");
                        cod = scanner.nextLong();
                        gg = tt.EvaluacionCodigo(mod, cod);
                        if(gg= true)
                            mod.get(u).setCodigoObra(cod);

                    }
                    if(ans==2)
                    {
                        System.out.println("Escriba el nuevo valor");
                        tit = scanner.next();
                        mod.get(u).setTitulo(tit);
                    }
                    if(ans==3)
                    {
                        System.out.println("Escriba el nuevo valor, con Dia, mes y año después");
                        año = scanner.nextInt();
                        mes= scanner.nextInt();
                        dia = scanner. nextInt();
                        fec = LocalDate.of(año, mes, dia);
                        mod.get(u).setFecha(fec);
                    }
                    if(ans==4)
                    {
                        System.out.println("Escriba el nuevo valor");
                        precioRef = scanner.nextFloat();
                        mod.get(u).setPrecioRef(precioRef);
                    }
                    if(ans==5)
                    {
                        System.out.println("Escriba el nuevo valor");
                        dimen = scanner.next();
                        mod.get(u).setDimensiones(dimen);
                    }
                    if(ans==6)
                    {
                        System.out.println("Escriba el nuevo valor");
                        kk = scanner.next();
                        mod.get(u).setArtista(kk);
                    }

                }
            }
        }else if(jj==true)
            System.out.println("No se pudo modificar nada pues la obra con codigo " + i +"no existe" );


    }
    public void Eliminar(List<Obra> gg)
    {
        int yu;
        Long i;
        boolean jj = false;
        Scanner scanner = new Scanner (System.in);

        System.out.println("¿Cuál Obra va a eliminar? ::: (Diga su posición)");
        i = scanner.nextLong();
        for(yu =0; yu< gg.size(); yu++)
        {
            if(i==gg.get(yu).getCodigoObra())
                jj=true;
        }
        if(jj==true)
        {
            if(gg.get(yu).getEstado()==true)
                gg.remove(yu);
        } else if(jj==false)
            System.out.println("No se pudo eliminar nada pues la obra con codigo " + i +"no existe" );

    }

    public void CrearArtista( List<Artista> uu)
    {
        int tam, año, mes, dia, ans;
        long codArt, cedu, tele;
        String nom, apell;
        LocalDate fechN;

        Scanner scanner = new Scanner (System.in);

        System.out.println("¿Ya habías ingresado antes?, Si(0) y vas a ingresar solo un nuevo artista o no(1) pero los vas a crear");
        ans= scanner.nextInt();
        if(ans == 0)
            tam = 1;
        else{
            System.out.println("¿Cuántos artistas son en total?");
            tam = scanner.nextInt();
        }
        for(int y=0; y<tam; y++)
        {
            System.out.println("-----------------------------------");
            System.out.println(" Codigo del Artista: ");
            codArt = scanner.nextLong();
            System.out.println(" Cedula del Artista: ");
            cedu = scanner.nextLong();
            System.out.println("Nombre");
            nom = scanner.next();
            System.out.println("Apellidos");
            apell = scanner.next();
            System.out.println("Fecha de Nacimiento: 1)Año 2)Mes 3)Dia");
            año = scanner.nextInt();
            mes= scanner.nextInt();
            dia = scanner. nextInt();
            fechN= LocalDate.of(año, mes, dia);
            System.out.println("Numero de Telefono");
            tele = scanner.nextLong();

            Artista num = new Artista(codArt, cedu, nom, apell, fechN, tele);
            uu.add(num);

        }

    }

    public Obra BuscaporTitulo(List<Obra> bb, String otro)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;

        for(int y=0; y<bb.size(); y++)
        {
            if(bb.get(y).getTitulo().equalsIgnoreCase(otro))
            {
                encontrado = true;
                System.out.println("-------------------");
                System.out.println("ENCONTRADO");
                System.out.println("Obra "+(y+1)+":" );
                System.out.println("Codigo de la Obra: "+ bb.get(y).getCodigoObra());
                System.out.println("Titulo : "+ bb.get(y).getTitulo());
                System.out.println("Fecha : "+ bb.get(y).getFecha());
                System.out.println("Precio de Referencia : "+ bb.get(y).getPrecioRef());
                System.out.println("Dimensiones: "+ bb.get(y).getDimensiones());
                System.out.println("Artista: "+ bb.get(y).getArtista());
                if(bb.get(y).getEstado()==false)
                    System.out.println("Estado: YA COMPRADO");
                else {
                    System.out.println("Estado: AUN Disponible");
                }
                obraEncontrada = bb.get(y);
            }
        }

        if(encontrado==false)
        {
            System.out.println("-------------------");
            System.out.println("NO FUE ENCONTRADO");
            System.out.println("-------------------");
        }

        return obraEncontrada;
    }
    
    public Obra BuscaporArtista(List<Obra> bb, String t)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;

        for(int y=0; y<bb.size(); y++)
        {
            if(bb.get(y).getArtista().equalsIgnoreCase(t))
            {
                encontrado = true;
                System.out.println("-------------------");
                System.out.println("ENCONTRADO");
                System.out.println("Obra "+(y+1)+":" );
                System.out.println("Codigo de la Obra: "+ bb.get(y).getCodigoObra());
                System.out.println("Titulo : "+ bb.get(y).getTitulo());
                System.out.println("Fecha : "+ bb.get(y).getFecha());
                System.out.println("Precio de Referencia : "+ bb.get(y).getPrecioRef());
                System.out.println("Dimensiones: "+ bb.get(y).getDimensiones());
                System.out.println("Artista: "+ bb.get(y).getArtista());
                if(bb.get(y).getEstado()==false)
                    System.out.println("Estado: YA COMPRADO");
                else {
                    System.out.println("Estado: AUN Disponible");
                }
                obraEncontrada = bb.get(y);
            }
        }

        if(encontrado==false)
        {
            System.out.println("-------------------");
            System.out.println("NO FUE ENCONTRADO");
            System.out.println("-------------------");
        }
        return obraEncontrada;
    }
    public Obra BuscaporFecha(List<Obra> bb, LocalDate yu)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;

        for(int y=0; y<bb.size(); y++)
        {
            if(bb.get(y).getFecha().equals(yu))
            {
                encontrado = true;
                System.out.println("-------------------");
                System.out.println("ENCONTRADO");
                System.out.println("Obra "+(y+1)+":" );
                System.out.println("Codigo de la Obra: "+ bb.get(y).getCodigoObra());
                System.out.println("Titulo : "+ bb.get(y).getTitulo());
                System.out.println("Fecha : "+ bb.get(y).getFecha());
                System.out.println("Precio de Referencia : "+ bb.get(y).getPrecioRef());
                System.out.println("Dimensiones: "+ bb.get(y).getDimensiones());
                System.out.println("Artista: "+ bb.get(y).getArtista());
                if(bb.get(y).getEstado()==false)
                    System.out.println("Estado: COMPRADO");
                else {
                    System.out.println("Estado: Disponible");
                }
                obraEncontrada = bb.get(y);
            }
        }

        if(encontrado==false)
        {
            System.out.println("-------------------");
            System.out.println("NO FUE ENCONTRADO");
            System.out.println("-------------------");
        }
        return obraEncontrada;
    }
}
