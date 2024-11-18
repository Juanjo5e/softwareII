package co.edu.uco.deviuco.usuarios.domain.sede;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.domain.Domain;
import co.edu.uco.deviuco.usuarios.domain.ciudad.CiudadDomain;
import co.edu.uco.deviuco.usuarios.domain.institucion.InstitucionDomain;

public class SedeDomain extends Domain {
	
	private String nombre;
	private CiudadDomain ciudad;
	private InstitucionDomain institucion;
	
	
	public SedeDomain(final UUID id, final String nombre, final CiudadDomain country, final InstitucionDomain intitucion) {
		super(id);
		setName(nombre);
		setCiudad(ciudad);
		setInstitucion(institucion);
	}


	public final  String getName() {
		return nombre;
	}


	private final void setName(String nombre) {
		this.nombre = nombre;
	}


	public final InstitucionDomain getInstitucion() {
		return institucion;
	}


	private final void setInstitucion(InstitucionDomain institucion) {
		this.institucion = institucion;
	}
	
	public final CiudadDomain getCiudad() {
		return ciudad;
	}


	private final void setCiudad(CiudadDomain ciudad) {
		this.ciudad = ciudad;
	}



}