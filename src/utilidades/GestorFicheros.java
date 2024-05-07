package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.CitasDto;
import dtos.ClienteDto;


public class GestorFicheros
{
	// metodo estatico que accede al fichero para poder ver el contenido 
	public static void accesoAFicheros(String rutaFicheroGeneral)
	{
        File archivo = new File(rutaFicheroGeneral);
        if (archivo.exists()) 
        {
            try {
                String[] contenidoFichero = Files.readAllLines(Paths.get(rutaFicheroGeneral)).toArray(new String[0]);

                for (String fichero : contenidoFichero) 
                {
                    String[] lineasContenido = fichero.split(";");
                    ClienteDto cliente = new ClienteDto( Long.parseLong(lineasContenido[0]),lineasContenido[1],
                    		lineasContenido[2],
                    		LocalDate.parse(lineasContenido[3],DateTimeFormatter.ofPattern("yyyy-MM-dd")), Boolean.parseBoolean(lineasContenido[4]));
                    Inicio.listaClientes.add(cliente);
                }

                System.out.println("Lista de Clientes registrados");
                for (String line : contenidoFichero)
                {
                    System.out.println(line);
                }
            } catch (IOException e) 
            {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else 
        {
            System.out.println("No existen Clientes registrados");
        }
}
	public static void guardarCita(String ficheroCitas) 
	{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheroCitas));
            String[] contenidoFicheroCitas = Files.readAllLines(Paths.get(ficheroCitas)).toArray(new String[0]);
            String linea;
            while ((linea = reader.readLine()) != null) 
            {
                String[] partesDeLaLinea = linea.split(";");
                CitasDto citas = new CitasDto(Long.parseLong(partesDeLaLinea[0]), partesDeLaLinea[1],
                        LocalDate.parse(partesDeLaLinea[2]));
              Inicio.listaCitas.add(citas);
            }
            System.out.println("Lista de citas registradas");
            for (String line : contenidoFicheroCitas) 
            {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) 
        {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
	// metodo estatico que genera el nombre del fichero log de acuerdo a la fecha 
	public static String nombreFichero() 
	 {
	        LocalDate fechaActual = LocalDate.now();
	        String diasFecha = DateTimeFormatter.ofPattern("dd").format(fechaActual);
	        String mesFecha = DateTimeFormatter.ofPattern("MM").format(fechaActual);
	        String anioFecha = DateTimeFormatter.ofPattern("yy").format(fechaActual);
	        String fechaCompleta = diasFecha + mesFecha + anioFecha;
	        String rutaArchivo = "C:\\Users\\Profesor\\eclipse-workspace\\jromresExamenED\\log" + fechaCompleta + ".txt";
	        return rutaArchivo;
	    }
// metodo estatico que sobreescribe en fichero log
	    public static void sobreEscribir(String accion)
	    {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero(), true)))
	        {
	            writer.write(accion + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
// metodo que crea el fichero
	    public static void creaFichero()
	    {
	        try {
	            FileWriter fw = new FileWriter(nombreFichero());
	            fw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
