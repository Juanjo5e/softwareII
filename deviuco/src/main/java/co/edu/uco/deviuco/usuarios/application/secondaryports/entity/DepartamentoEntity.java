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
@Table(name = "departamento")
public final class DepartamentoEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "pais")
	private PaisEntity pais;

	DepartamentoEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setPais(PaisEntity.create());
	}

	public DepartamentoEntity(final UUID id, final String nombre, final PaisEntity pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}
	
	public static final DepartamentoEntity create() {
		return new DepartamentoEntity();
	}
	
	
	public static final DepartamentoEntity create(final UUID id, final String nombre, final PaisEntity pais) {
		return new DepartamentoEntity(id, nombre, pais);
	}
	
	public static final DepartamentoEntity create(final UUID id) {
		return new DepartamentoEntity(id, TextHelper.EMPTY, PaisEntity.create());
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

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(final PaisEntity pais) {
		this.pais = ObjectHelper.getDefault(pais, PaisEntity.create());
	}

}