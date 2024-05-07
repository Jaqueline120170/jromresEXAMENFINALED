package servicios;

import java.io.IOException;

public interface EmpleadoInterfaz 
{
	//Metodo para validar clientes en funcion del dni
	public void validarCliente()throws IOException ;
	//metodo para generar el fichero de las citas en una fecha especifica
	public void mostrarCitas()throws IOException;
}
