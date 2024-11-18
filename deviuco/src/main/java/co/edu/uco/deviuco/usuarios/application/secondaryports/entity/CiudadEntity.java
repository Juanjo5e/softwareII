package co.edu.uco.deviuco.usuarios.application.secondaryports.entity;


import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public final class CiudadEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "departamento")
	private DepartamentoEntity departamento;

	CiudadEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setDepartamento(DepartamentoEntity.create());
	}

	public CiudadEntity(final UUID id, final String nombre, final DepartamentoEntity departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static final CiudadEntity create() {
		return new CiudadEntity();
	}
	
	
	public static final CiudadEntity create(final UUID id, final String nombre, final DepartamentoEntity departamento) {
		return new CiudadEntity(id, nombre, departamento);
	}
	
	public static final CiudadEntity create(final UUID id) {
		return new CiudadEntity(id, TextHelper.EMPTY, DepartamentoEntity.create());
	}


	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	public DepartamentoEntity getDepartamento() {
		return departamento;
	}

	public void setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = ObjectHelper.getDefault(departamento, DepartamentoEntity.create());
	}

}