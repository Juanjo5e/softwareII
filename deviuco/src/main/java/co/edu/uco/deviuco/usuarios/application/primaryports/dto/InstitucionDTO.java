package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class InstitucionDTO {
	
	private UUID id;
	private String nombre;
	
	
	public InstitucionDTO() {
		setId(id);
		setNombre(nombre);
	}
	
	public static InstitucionDTO create(final UUID id, final String nombre) {
		return new InstitucionDTO();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);		
	}
	
	

}
