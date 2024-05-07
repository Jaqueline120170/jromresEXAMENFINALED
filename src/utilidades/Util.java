package utilidades;

import controladores.Inicio;

public class Util {
	
public static long calcularIdCliente() {
		
		long nuevoId = 0;
		int tamanio = Inicio.listaClientes.size();

		if (tamanio > 0)
		{

		    nuevoId = Inicio.listaClientes.get(tamanio - 1).getIdCliente()+1;

		}
		else
		{

		    nuevoId = 1;

		}

		return nuevoId;

		
	}
public static long calcularIdCita() {
	
	long nuevoId = 0;
	int tamanio = Inicio.listaCitas.size();

	if (tamanio > 0)
	{

	    nuevoId = Inicio.listaCitas.get(tamanio - 1).getIdCita()+1;

	}
	else
	{

	    nuevoId = 1;

	}

	return nuevoId;

	
	
/*public static mostrarClientesSinValidar()
{
	boolean validado;
	if(validado)
}
*/
}
}
