package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import controladores.Inicio;
import dtos.CitasDto;
import dtos.ClienteDto;

public class ClienteImplementacion implements ClienteInterfaz

{
	Scanner sc = new Scanner (System.in);
	public void registrarCliente()throws IOException 
	{
		System.out.println("REGISTRO CLIENTE");
		System.out.println("---------------------");
		long id = utilidades.Util.calcularIdCliente();
		System.out.println("Introduzca su nombre completo separado por espacios iniciando por los apellidos");
		String nombre= sc.nextLine();
		System.out.println("Introduzca su DNI");
		String dni = sc.next();
		LocalDate fecha = LocalDate.now();
		boolean validado = false;
		ClienteDto cliente = new ClienteDto(id,nombre,  dni, fecha, validado);
		Inicio.listaClientes.add(cliente);
		
		System.out.println("El cliente se ha registrado con exito");
		utilidades.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " Registro cliente");
	}
	
	public void solicitarCita()throws IOException
	{
		System.out.println("SOLICITAR CITA MEDICA");
		System.out.println("---------------------");
		long id= utilidades.Util.calcularIdCita();
		System.out.println("Introduzca su DNI");
		String dni = sc.next();
		 boolean esValidado = false;
		for(ClienteDto cliente : Inicio.listaClientes)
		{	
			
			if(cliente.getDniCliente().equals(dni) &  cliente.isEsValidado() == true) 
			{
				int opcionEspecialidad= mostrarmenuEspecialidades() ;
				switch(opcionEspecialidad) 
				{
				case 1 :
						
				case 2:
			
				case 3:
					System.out.println("Introduzca la fecha para la cual desea su cita (dd-MM-YYYY)");
					String fecha = sc.next();
					System.out.println("Introduzca la fecha para la cual desea su cita (hh:mm)");
					String hora = sc.next();
					LocalDate fechaSolicitud = LocalDate.now();
					System.out.println("Su cita ha sido registrada con exito para la fecha : " + fecha + "y hora indicada: " + hora);
					CitasDto cit = new CitasDto(id,dni, fechaSolicitud);
					Inicio.listaCitas.add(cit);
					break;
				default:
                    System.out.println("No hay datos disponibles");
				}
			
			
			}
			else
			{
				System.out.println("El cliente no existe o no ha sido validado, verifiquelo y vuelva a intentarlo");
			}
		}
		utilidades.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " Solicitud de cita medica");
	}
	///Metodo que le muesra especialidades al cliente para solicitar cita
	private int mostrarmenuEspecialidades() 
	{
		int seleccionEspecialidad;
		System.out.println("1. Psicologia");
		System.out.println("2. Traumatologia");
		System.out.println("3. Fisioterapia");
		System.out.println("Seleccione la especialidad de la cual desea solicitar una cita");
		seleccionEspecialidad= sc.nextInt();
		return seleccionEspecialidad;
	}
	
	public void citaPorIntervalo() 
	{
		System.out.println("SOLICITAR CITA MEDICA POR INTERVALO");
		System.out.println("---------------------");
		System.out.println("CALCULO PEDIDOS TOTALES ENTRE 2 FECHAS");
        System.out.println("---------------------------");

        System.out.println("Ingrese la primera fecha (yyyy-MM-dd): ");
        String fechaInicioString = sc.next();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("Ingrese la segunda fecha (yyyy-MM-dd): ");
        String fechaFinString = sc.next();
        LocalDate fechaFin = LocalDate.parse(fechaFinString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        

		
	}
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
