package servicios;
import servicios.EmpleadoImplementacion;

import java.io.IOException;
import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz
{
	ClienteInterfaz ci = new ClienteImplementacion();
	EmpleadoInterfaz ei = new EmpleadoImplementacion();
	Scanner sc = new Scanner (System.in);
	public int mostrarMenu()throws IOException 
	{
		int seleccionUsuario;
		System.out.println("MENU PRINCIPAL");
		System.out.println("------------------");
		System.out.println("0. Cerrar Menu");
		System.out.println("1. Acceder menu empleado");
		System.out.println("2. Acceder menu cliente");
		System.out.println("Seleccione una opcion");
		seleccionUsuario = sc.nextInt();
		return seleccionUsuario;
		
	}
	// metodo que mustra el menu al empleado
	private int menuEmpleado() 
	{
		int opcionEmpleado;
		System.out.println("MENU EMPLEADO");
		System.out.println("------------------");
		System.out.println("0. Volver");
		System.out.println("1. Validar cliente");
		System.out.println("2.Imprimir citas medicas");
		System.out.println("Seleccione una opcion");
		opcionEmpleado = sc.nextInt();
		return opcionEmpleado;
	}
	
	public void seleccionEmpleado()throws IOException
	{
		int seleccionEmpleado;
		seleccionEmpleado = menuEmpleado();
		switch(seleccionEmpleado)
		{
		case 0:
			break;
		case 1:
			ei.validarCliente();
			break;
		case 2:
			ei.mostrarCitas();
		default:
			System.out.println("INTRODUZCA OPCION VALIDA");
			break;
		}
	}
	// metodo que muestra el menu al cliente
	private int menuCliente() 
	{
		int opcionEmpleado;
		System.out.println("MENU Cliente");
		System.out.println("------------------");
		System.out.println("0. Volver");
		System.out.println("1. Registro");
		System.out.println("2. Solicitar cita medica");
		System.out.println("3. Consultar citas medicas");
		System.out.println("Seleccione una opcion");
		opcionEmpleado = sc.nextInt();
		return opcionEmpleado;
	}
	public void seleccionCliente()throws IOException
	{
		int seleccionCliente;
		seleccionCliente = menuCliente();
		switch(seleccionCliente)
		{
		case 0:
			break;
		case 1:
			ci.registrarCliente();
			break;
		case 2:
			ci.solicitarCita();
			break;
		default:
			System.out.println("INTRODUZCA OPCION VALIDA");
			break;
		}
	}
	
}
