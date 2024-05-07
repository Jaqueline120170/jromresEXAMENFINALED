package controladores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

import dtos.CitasDto;
import dtos.ClienteDto;

public class Inicio {
	//Listas estaticas y atributos para poder acceder a ellos desde cualquier parte del codigo
	public static List<CitasDto> listaCitas = new ArrayList<CitasDto>();
	public static List<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
	static LocalDateTime fechaActual = LocalDateTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// metodo principal de la aplicacion
	public static String fechaYhora = fechaActual.format(formatter);
	

	public static void main(String[] args)
	{
		MenuInterfaz mi = new MenuImplementacion();
		
		// variables de flujo
		int opcionPrincipal;
		boolean cerrarMenu=false;
		
		//Acceso a ficheros
		  String rutaArchivo ="C:\\Users\\Profesor\\eclipse-workspace\\jromresExamenED\\registros.txt";
		  String rutaCitas = "C:\\Users\\Profesor\\eclipse-workspace\\jromresExamenED\\citas.txt";
          utilidades.GestorFicheros.accesoAFicheros(rutaArchivo);
          utilidades.GestorFicheros.guardarCita(rutaCitas);
          utilidades.GestorFicheros.creaFichero();
		
		
		while(!cerrarMenu) 
		{
			try 
			{
			opcionPrincipal = mi.mostrarMenu();
			switch(opcionPrincipal) 
			{
			case 0:
				utilidades.GestorFicheros.sobreEscribir(fechaYhora +  " Acceso a menu principal");
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
		            for (ClienteDto cliente : listaClientes) {
		                if (cliente.getIdCliente() != 0) {
		                    bw.write(cliente.getIdCliente() + ";" + cliente.getNombreCompleto()
		                            + ";" +  cliente.getDniCliente()+ ";" + cliente.getFechaRegistro()+";" 
		                    		+ cliente.isEsValidado());
		                    bw.newLine();
		                }
		            }
				}catch (Exception e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                }
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaCitas))) {
		            for (CitasDto cit : listaCitas) {
		                if (cit.getIdCita() != 0) {
		                    bw.write(cit.getIdCita() + ";" + cit.getDniCliente()
		                            + ";" + cit.getFecha());
		                    bw.newLine();
		                }
		            }
				}catch (Exception e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                }
				
				cerrarMenu=true;
			case 1:
				utilidades.GestorFicheros.sobreEscribir(fechaYhora +  "1  Acceso a menu empleados");
				mi.seleccionEmpleado();
				break;
			case 2:
				mi.seleccionCliente();
				utilidades.GestorFicheros.sobreEscribir(fechaYhora +  " Acceso a menu clientes");
				break;
			default:
				System.out.println("INTRODUZCA UNA OPCION VALIDA");
				break;
		
			}
		}
		
		catch(Exception e ) {
			System.out.println("No se ha podido leer/escribir" + e.getMessage());
			e.printStackTrace();

		} 
		}

	}

}
