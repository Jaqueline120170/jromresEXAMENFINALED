package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitasDto {

	long idCita;
	String especialidad;
	String dniCliente;
	LocalDate fecha = LocalDate.now();
	LocalDateTime fechaCita=LocalDateTime.of(9999, 12, 31,00,00,00);
	
	
	
	
	
	public CitasDto(long idCita, String dniCliente, LocalDate fecha) {
		super();
		this.idCita = idCita;
		this.dniCliente = dniCliente;
		this.fecha = fecha;
	}
	public long getIdCita() {
		return idCita;
	}
	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	
	
	
	
}
