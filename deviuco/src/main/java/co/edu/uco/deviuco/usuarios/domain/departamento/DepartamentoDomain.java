package co.edu.uco.deviuco.usuarios.domain.departamento;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.domain.Domain;
import co.edu.uco.deviuco.usuarios.domain.pais.PaisDomain;

public class DepartamentoDomain extends Domain{
	
	private String nombre;
	private PaisDomain pais;
	
	
	public DepartamentoDomain(final UUID id, final String nombre, final PaisDomain pais) {
		super(id);
		setNombre(nombre);
		setPais(pais);
	}


	public final  String getNombre() {
		return nombre;
	}


	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public final PaisDomain getPais() {
		return pais;
	}


	private final void setPais(PaisDomain pais) {
		this.pais = pais;
	}



}