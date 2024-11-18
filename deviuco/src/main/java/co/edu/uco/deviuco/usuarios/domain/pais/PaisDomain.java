package co.edu.uco.deviuco.usuarios.domain.pais;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.domain.Domain;

public class PaisDomain extends Domain {
	
	private String nombre;

	public PaisDomain(final UUID id, String nombre) {
		super(id);
		setNombre(nombre);
		
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}

