package co.edu.uco.deviuco.usuarios.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "institucion")
public final class InstitucionEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	InstitucionEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}

	public InstitucionEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final InstitucionEntity create() {
		return new InstitucionEntity();
	}
	
	
	public static final InstitucionEntity create(final UUID id, final String nombre) {
		return new InstitucionEntity(id, nombre);
	}
	
	public static final InstitucionEntity create(final UUID id) {
		return new InstitucionEntity(id, TextHelper.EMPTY);
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

}