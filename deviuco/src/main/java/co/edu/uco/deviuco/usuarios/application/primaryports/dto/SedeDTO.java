package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class SedeDTO {
	private UUID id;
	private String nombre;
	private CuidadDTO ciudad;
	private InstitucionDTO institucion;
	
	
	public SedeDTO() {
		setId(id);
		setNombre(nombre);
		setCiudad(new CuidadDTO());
		setInstitucion(new InstitucionDTO());
	}
	
	public static SedeDTO create(final UUID id, final String nombre, final CuidadDTO ciudad, final InstitucionDTO institucion ) {
		return new SedeDTO();
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
	
	public CuidadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CuidadDTO ciudad) {
        this.ciudad = ciudad;
    }
	
    public InstitucionDTO getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionDTO institucion) {
        this.institucion = institucion;
    }
	
	

}

