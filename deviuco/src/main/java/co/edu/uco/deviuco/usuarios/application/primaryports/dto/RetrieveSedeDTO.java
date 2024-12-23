package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class RetrieveSedeDTO {
	private UUID id; 
	private String nombre;
	private CuidadDTO ciudad;
	private InstitucionDTO institucion ;
	
	public RetrieveSedeDTO() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setCiudad(ciudad);
		setInstitucion(institucion);
	}
	
	
	
	public RetrieveSedeDTO(UUID id, String nombre, CuidadDTO ciudad, InstitucionDTO institucion) {
		setId(id);
		setNombre(nombre);
		setCiudad(ciudad);
		setInstitucion(institucion);
	}
	
	public static RetrieveSedeDTO create () {
		return new RetrieveSedeDTO();
	}
	
	public static  RetrieveSedeDTO create(UUID id, String nombre, CuidadDTO ciudad, InstitucionDTO institucion) {
		return new RetrieveSedeDTO(id, nombre, ciudad, institucion);
		
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

	public CuidadDTO getCountry() {
		return ciudad;
	}



	public void setCiudad(CuidadDTO ciudad) {
		this.ciudad = ciudad;
	}
	
	public InstitucionDTO getInstitucion() {
		return institucion;
	}



	public void setInstitucion(InstitucionDTO institucion) {
		this.institucion= institucion;
	}
	

}
