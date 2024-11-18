package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class TipoIdentificacionDTO {
	private UUID id;
	private String nombre;
	
	
	public TipoIdentificacionDTO() {
		setId(id);
		setName(nombre);
	}
	
	public static TipoIdentificacionDTO create(final UUID id, final String nombre) {
		return new TipoIdentificacionDTO();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre= TextHelper.applyTrim(nombre);		
	}
	
	

}
