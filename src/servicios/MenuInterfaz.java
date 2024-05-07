package servicios;

import java.io.IOException;

public interface MenuInterfaz
{
	// metodo que muestra el menu principal al inicio de la aplkicacion
	public int mostrarMenu()throws IOException ;
	// metodo que muestra el menu del empleado
	public void seleccionEmpleado()throws IOException;
	//metodo que muestra  el menu al cliente
	public void seleccionCliente()throws IOException;
}
