package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class TipoUbicacionDTO {
	private UUID id;
	private String nombre;
	
	
	public TipoUbicacionDTO() {
		setId(id);
		setNombre(nombre);
	}
	
	public static TipoUbicacionDTO create(final UUID id, final String nombre) {
		return new TipoUbicacionDTO();
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

	public void setNombre(String name) {
		this.nombre = TextHelper.applyTrim(nombre);		
	}
	
	

}