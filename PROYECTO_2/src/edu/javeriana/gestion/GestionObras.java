package edu.javeriana.gestion;

import java.time.LocalDate;
import java.util.*;

import edu.javeriana.entidades.Artista;
import edu.javeriana.entidades.Obra;

public class GestionObras {
	
	private ControladorGaleria galeria;
	
	public GestionObras(ControladorGaleria galeriaPadre) {
		this.galeria = galeriaPadre;
	}

	// Resuelve el punto 1 del ejercicio
    public void LlenarListaObras( )
    {
        int ia, año, mes, dia;
        long cod;
        String tit, dimen, arts;
        LocalDate fec;
        float precioRef;
	    boolean artistaSeleccionado = false;
	    int opcion;

	    List<Artista> artistas = galeria.getListaArtistias();
        List<Obra> lista = galeria.getListaObras();

        try (Scanner scanner = new Scanner (System.in)) {
			System.out.println("BIENVENIDO...DIGANOS ¿Cuantas obras existen en galería?");
			ia = scanner.nextInt();

			for(int y=0; y<ia; y++)
			{
			    System.out.println(" Vamos a llenar la lista... Escribe los Datos de la Obra: " + (y+1) + " de " + ia);
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
			    
			    // Selecciona los artistas para cada obra
			    List<Artista> autores = new LinkedList<Artista>();
				while(artistaSeleccionado==false)
			    {
			    	System.out.println("Selecciona el autor de esta obra, o crea uno nuevo:");
					for(int h=0; h< artistas.size(); h++)
				    {
				    	System.out.println((h+1) + ". " + artistas.get(h).getNombre() + " " + artistas.get(h).getApellidos());
				    }
			    	System.out.println((artistas.size()+1) + "Crear nuevo artista.");
				    opcion = scanner.nextInt();
					if(opcion == artistas.size())
				    {
				    	Artista nuevoArtista = CrearArtista();
				    	autores .add(nuevoArtista);
				    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
					    arts = scanner.next();
					    if(arts.equalsIgnoreCase("si"))
					    {
					    	artistaSeleccionado = false;
					    }else {
					    	artistaSeleccionado = true;
					    }
				    }else if(opcion <= 0 || opcion > artistas.size())
				    {
				    	System.out.println("Esta opcion no es valida.");
				    }else if(opcion < artistas.size())
				    {
				    	autores.add(artistas.get(opcion - 1));
				    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
					    arts = scanner.next();
					    if(arts.equalsIgnoreCase("si"))
					    {
					    	artistaSeleccionado = false;
					    }else {
					    	artistaSeleccionado = true;
					    }
				    }
			    }

			    Obra num = new Obra(cod, tit, fec, precioRef, dimen, autores);
			    lista.add(num);
			}
		}
    }

    public void InsertarNuevaObra()
    {
        int año, mes, dia;
        long cod;
        String tit, dimen, arts;
        LocalDate fec;
        float precioRef;
        boolean hy;
        boolean artistaSeleccionado = false;
        List<Artista> autores = galeria.getListaArtistias();
        List<Obra> actual = galeria.getListaObras();
        List<Artista> artistas = galeria.getListaArtistias();

        try (Scanner scanner = new Scanner (System.in)) {
			Obra ab = null;
			Artista nuevoArtista = null;
			System.out.println(" Vamos a Agregar una nueva obra a la lista... Escribe los Datos de la Obra");
			System.out.println(" Codigo de la Obra");
			cod = scanner.nextLong();
			int opcion;

			hy = Obra.EvaluacionCodigo(actual, cod);
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
			    while(artistaSeleccionado==false)
			    {
			    	System.out.println("Selecciona el autor de esta obra, o crea uno nuevo:");
				    for(int h=0; h< artistas.size(); h++)
				    {
				    	System.out.println((h+1) + ". " + artistas.get(h).getNombre() + " " + artistas.get(h).getApellidos());
				    }
			    	System.out.println((artistas.size()+1) + "Crear nuevo artista.");
				    opcion = scanner.nextInt();
				    if(opcion == artistas.size())
				    {
				    	nuevoArtista = CrearArtista();
				    	autores.add(nuevoArtista);
				    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
					    arts = scanner.next();
					    if(arts.equalsIgnoreCase("si"))
					    {
					    	artistaSeleccionado = false;
					    }else {
					    	artistaSeleccionado = true;
					    }
				    }else if(opcion <= 0 || opcion > artistas.size())
				    {
				    	System.out.println("Esta opcion no es valida.");
				    }else if(opcion < artistas.size())
				    {
				    	autores.add(artistas.get(opcion - 1));
				    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
					    arts = scanner.next();
					    if(arts.equalsIgnoreCase("si"))
					    {
					    	artistaSeleccionado = false;
					    }else {
					    	artistaSeleccionado = true;
					    }
				    }
			    }
			    ab = new Obra(cod, tit, fec, precioRef, dimen, autores);
			    actual.add(ab);
			}
		}
    }

    public void Modificar()
    {
        int ans, yu;
        int año, mes, dia;
        long cod, i;
        String tit, dimen;
        LocalDate fec;
        float precioRef;
        boolean gg = true;
        boolean jj = false;
        List<Obra> mod = galeria.getListaObras();

        try (Scanner scanner = new Scanner (System.in)) {
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
			                gg = Obra.EvaluacionCodigo(mod, cod);
			                if(gg == true)
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
						    boolean artistaSeleccionado = false;
						    int opcion;
						    Artista nuevoArtista;
						    String arts;
						    List<Artista> autores = new LinkedList<Artista>();
						    List<Artista> artistas = galeria.getListaArtistias();
							while(artistaSeleccionado==false)
						    {
						    	System.out.println("Selecciona el autor de esta obra, o crea uno nuevo:");
								for(int h=0; h< artistas.size(); h++)
							    {
							    	System.out.println((h+1) + ". " + artistas.get(h).getNombre() + " " + artistas.get(h).getApellidos());
							    }
						    	System.out.println((artistas.size()+1) + "Crear nuevo artista.");
							    opcion = scanner.nextInt();
							    if(opcion == artistas.size())
							    {
							    	nuevoArtista = CrearArtista();
							    	autores.add(nuevoArtista);
							    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
								    arts = scanner.next();
								    if(arts.equalsIgnoreCase("si"))
								    {
								    	artistaSeleccionado = false;
								    }else {
								    	artistaSeleccionado = true;
								    }
							    }else if(opcion <= 0 || opcion > artistas.size())
							    {
							    	System.out.println("Esta opcion no es valida.");
							    }else if(opcion < artistas.size())
							    {
							    	autores.add(artistas.get(opcion - 1));
							    	System.out.println("Desea seleccionar más artistas? escriba SI, de lo contrario digite cualquier texto");
								    arts = scanner.next();
								    if(arts.equalsIgnoreCase("si"))
								    {
								    	artistaSeleccionado = false;
								    }else {
								    	artistaSeleccionado = true;
								    }
							    }
						    }
			                mod.get(u).setArtista(autores);
			            }

			        }
			    }
			}else if(jj==true)
			    System.out.println("No se pudo modificar nada pues la obra con codigo " + i +"no existe" );
		}


    }
    public void Eliminar()
    {
        int yu;
        Long i;
        boolean jj = false;
        List<Obra> gg = galeria.getListaObras();
        try (Scanner scanner = new Scanner (System.in)) {
			System.out.println("¿Cuál Obra va a eliminar? ::: (Diga su posición)");
			i = scanner.nextLong();
		}

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

    public Artista CrearArtista()
    {
        int tam, año, mes, dia, ans;
        long codArt, cedu, tele;
        String nom, apell;
        LocalDate fechN;
        Artista num = null;
        List<Artista> uu = galeria.getListaArtistias();

        try (Scanner scanner = new Scanner (System.in)) {
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

			    num = new Artista(codArt, cedu, nom, apell, fechN, tele);
			    uu.add(num);

			}
		}
        return num;
    }

    public Obra BuscaporTitulo(String otro)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;
        List<Obra> bb = galeria.getListaObras();
        
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
    
    public Obra BuscaporArtista(long t)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;
        List<Obra> bb = galeria.getListaObras();

        for(int y=0; y<bb.size(); y++)
        {
        	List<Artista> autores = bb.get(y).getArtista();
        	for(int x=0; x<autores.size(); x++)
            {
	            if(autores.get(x).getCodigoArtista() == t)
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
        }

        if(encontrado==false)
        {
            System.out.println("-------------------");
            System.out.println("NO FUE ENCONTRADO");
            System.out.println("-------------------");
        }
        return obraEncontrada;
    }
    public Obra BuscaporFecha(LocalDate yu)
    {
        boolean encontrado = false;
        Obra obraEncontrada = null;
        List<Obra> bb = galeria.getListaObras();

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
