package co.edu.uco.deviuco.usuarios.domain.ubicacion;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.domain.Domain;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;

public class UbicacionDomain extends Domain {
	
	private String nombre;
	private SedeDomain sede;
	private TipoUbicacionDomain tipoUbicacion;

	public UbicacionDomain(final UUID id, final String nombre,final SedeDomain sede, final TipoUbicacionDomain tipoUbicacion) {
		super(id);
		setNombre(nombre);
		setSede(sede);
		setTipoUbicacion(tipoUbicacion);
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre= nombre;
	}

	public final SedeDomain getSede(){
		return sede;
	}

	private final void setSede(SedeDomain sede) {
		this.sede = sede;
	}
	
	public final TipoUbicacionDomain getTipoUbicacion(){
		return tipoUbicacion;
	}

	private final void setTipoUbicacion(TipoUbicacionDomain tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}


}