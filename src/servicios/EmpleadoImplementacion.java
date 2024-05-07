package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controladores.Inicio;
import dtos.CitasDto;
import dtos.ClienteDto;


public class EmpleadoImplementacion  implements EmpleadoInterfaz
{
	Scanner sc = new Scanner (System.in);

	public void validarCliente()throws IOException 
	{
		
			System.out.println("CLIENTES SIN  VALIDAR");
			 List<ClienteDto> listaAuxiliar = new ArrayList<ClienteDto>();

	        for (ClienteDto cliente : Inicio.listaClientes)
	        {
	            if (cliente.isEsValidado() == false)
	            {
	               
	                System.out.println("DNI: " + cliente.getDniCliente());
	                System.out.println("NOMBRE: " + cliente.getNombreCompleto());
	              
	                Inicio.listaClientes.add(cliente);
	            }

	        }

	        if (listaAuxiliar.size() > 0)
	        {
	            System.out.println("Introduzca  el dni del cliente que deseas validar: ");
	            String dniClienteAValidar = sc.next();
	            for (ClienteDto cliente : Inicio.listaClientes)
	            {
	                if (cliente.getDniCliente().equals(dniClienteAValidar))
	                {
	                    cliente.setEsValidado(true);
	                    System.out.println("El cliente con dni " + dniClienteAValidar + " ha sido validado con exito");
	                }
	            }
	        }
	        utilidades.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " Validacion de clientes"); 
	}
	/// metodo que le muestra al empleado el estado de validacion de los clientes
	private void mostrarValidacionClientes() {
		
        System.out.println("MOSTRAR CLIENTES");
        for (ClienteDto cliente : Inicio.listaClientes)
        {
            
            System.out.println("DNI: " + cliente.getDniCliente());
            System.out.println("NOMBRE: " + cliente.getApellido1() + " " +
                cliente.getApellido2() + ", " + cliente.getNombreCliente());
            String validacionStatus;
            if (cliente.isEsValidado() == true)
            {
                validacionStatus = "si";
            }
            else
            {
                validacionStatus = "no";
            }
            System.out.println("CLIENTE VALIDADO: " + validacionStatus);
          
        }
	
	}
	
	
		
	public void mostrarCitas() throws IOException{
		    try {
		        if (Inicio.listaCitas.size() > 0) {
		        	LocalDate fechaSeleccionada = leerFecha();
		            
		            LocalDateTime fechaActual = LocalDateTime.now();
		    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    		String fechaFormat = fechaActual.format(formatter);
		    		String ficheroCitas = "informe-".concat(fechaFormat).concat(".txt");
		            FileWriter fw = new FileWriter(ficheroCitas);
		            PrintWriter pw = new PrintWriter(fw);

		            for (CitasDto citas : Inicio.listaCitas) {
		            	
		                if (citas.getFecha().equals(fechaSeleccionada)) {
		                    String fechaFormateada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		                    String cita = "Citas: " + citas.getIdCita() 
		                    + ", Paciente con DNI: " + citas.getDniCliente()
		                    + ", Fecha : " + fechaFormateada;
		                    pw.println(cita);
		                }
		            }
		            
		            pw.close();
		            fw.close();
		            
		            System.out.println("Se ha creado el archivo '" + ficheroCitas + "' correctamente.");
		        } else {
		            System.out.println("No hay productos registrados.");
		        }
		    } catch (IOException e) {
		        System.out.println("Error al crear el archivo: " + e.getMessage());
		    }
		    utilidades.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " creacion de fichero");
		}
		
		
	
// metodo privado que solicita la fecha y se encarga de formatearla , sino es valida la solicita de nuevo
			
	private LocalDate leerFecha() 
	{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Introduzca una fecha (yyyy-MM-dd)");
		String fechaEscogida = sc.next();

		try 
		{
			return LocalDate.parse(fechaEscogida, formato);
		} catch (DateTimeParseException e) 
		{
			System.out.println(
					"Error: La fecha ingresada no es válida. Por favor, ingrese una fecha en formato yyyy-MM-dd.");
			return leerFecha(); 
		}
	}
}
