package dtos;

import java.time.LocalDate;

public class ClienteDto {

	
	long idCliente;
	String dniCliente;
	String nombreCliente;
	String apellido1;
	String apellido2;
	String nombreCompleto;
	LocalDate fechaRegistro= LocalDate.now();
	boolean esValidado;
	
	
	
	public ClienteDto() {
		super();
	}


	
	

	public ClienteDto(long idCliente, String nombreCompleto,String dniCliente, LocalDate fechaRegistro,
			boolean esValidado) {
		super();
		
		this.dniCliente = dniCliente;
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		String[] arregloNombre = nombreCompleto.split(" ");
		this.apellido1 = arregloNombre[0];
		this.apellido2 = arregloNombre[1];
		this.nombreCliente= arregloNombre[2];
		this.fechaRegistro = fechaRegistro;
		this.esValidado = esValidado;
	}


	


	public long getIdCliente() {
		return idCliente;
	}





	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}





	public String getDniCliente() {
		return dniCliente;
	}





	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}





	public String getNombreCliente() {
		return nombreCliente;
	}





	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}





	public String getApellido1() {
		return apellido1;
	}





	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}





	public String getApellido2() {
		return apellido2;
	}





	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}





	public String getNombreCompleto() {
		return nombreCompleto;
	}





	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}





	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}





	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}





	public boolean isEsValidado() {
		return esValidado;
	}





	public void setEsValidado(boolean esValidado) {
		this.esValidado = esValidado;
	}





	@Override
	public String toString() {
		return "ClienteDto [dniCliente=" + dniCliente + ", nombreCompleto=" + nombreCompleto + "]";
	}



	
	
	
}
