package servicios;

import java.io.IOException;

public interface ClienteInterfaz 
{
	///Metodo que registra un nuevo cliente, solicita una serie de datos y crea un lnuevo ClienteDto y lo añade  alista clientes
	public void registrarCliente() throws IOException;
	// metodo para que el cliente pueda solicitar una cita
	public void solicitarCita()throws IOException;
	public void citaPorIntervalo();
}
