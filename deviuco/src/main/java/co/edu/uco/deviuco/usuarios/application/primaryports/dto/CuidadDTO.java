package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;


public class CuidadDTO {
	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;
	
	public CuidadDTO() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setDepartamento(new DepartamentoDTO());
	}
	
	
	
	public CuidadDTO(UUID id, String nombre, DepartamentoDTO departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static CuidadDTO create () {
		return new CuidadDTO();
		
	}
	public static CuidadDTO create(UUID id, String nombre, DepartamentoDTO departamento) {
		return new CuidadDTO(id, nombre, departamento);
		
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
	
	public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento= departamento;
    }

}
