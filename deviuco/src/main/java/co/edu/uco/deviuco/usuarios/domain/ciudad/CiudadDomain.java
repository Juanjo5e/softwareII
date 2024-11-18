package co.edu.uco.deviuco.usuarios.domain.ciudad;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.domain.Domain;
import co.edu.uco.deviuco.usuarios.domain.departamento.DepartamentoDomain;

public class CiudadDomain extends Domain {
	
	private String nombre;
	private DepartamentoDomain departamento;

	public CiudadDomain(final UUID id, final String nombre,final DepartamentoDomain departamento) {
		super(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}

	private final void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = departamento;
	}


}