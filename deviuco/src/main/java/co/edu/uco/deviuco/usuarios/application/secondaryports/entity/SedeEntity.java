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
@Table(name = "sede")
public final class SedeEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "institucion")
	private InstitucionEntity institucion;
	
	@ManyToOne
	@JoinColumn(name = "ciudad")
	private CiudadEntity ciudad;

	SedeEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setCiudad(CiudadEntity.create());
		setInstitucion(InstitucionEntity.create());
	}

	public SedeEntity(final UUID id, final String nombre, final InstitucionEntity institucion, CiudadEntity ciudad) {
		setId(id);
		setNombre(nombre);
		setInstitucion(institucion);
		setCiudad(ciudad);
	}
	
	public static final SedeEntity create() {
		return new SedeEntity();
	}
	
	
	public static final SedeEntity create(final UUID id, final String nombre, final InstitucionEntity institucion, final CiudadEntity ciudad) {
		return new SedeEntity(id, nombre, institucion, ciudad);
	}
	
	public static final SedeEntity create(final UUID id) {
		return new SedeEntity(id, TextHelper.EMPTY, InstitucionEntity.create(), CiudadEntity.create());
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

	public InstitucionEntity getInstitucion() {
		return institucion;
	}

	public void setInstitucion(final InstitucionEntity institucion) {
		this.institucion= ObjectHelper.getDefault(institucion, InstitucionEntity.create());
	}
	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(final CiudadEntity ciudad) {
		this.ciudad = ObjectHelper.getDefault(ciudad, CiudadEntity.create());
	}


}