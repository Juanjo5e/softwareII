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
@Table (name = "ubicacion")
public final class UbicacionEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column (name = "nombre")
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name= "sede")
	private SedeEntity sede;
	
	@ManyToOne
	@JoinColumn(name= "tipoubicacion")
	private TipoUbicacionEntity tipoUbicacion;


	UbicacionEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setSede(SedeEntity.create());
		setTipoUbicacion(TipoUbicacionEntity.create());
		setSede(SedeEntity.create());
	}


	public UbicacionEntity(UUID id, String nombre, TipoUbicacionEntity tipoUbicacion, SedeEntity sede) {
		setId(id);
		setNombre(nombre);
		setTipoUbicacion(tipoUbicacion);
		setSede(sede);
	}
	
	public static final UbicacionEntity create() {
		return new UbicacionEntity();
	}
	
	
	public static final UbicacionEntity create(final UUID id, final String name, final SedeEntity sede, final TipoUbicacionEntity tipoUbicacion) {
		return new UbicacionEntity(id, name, tipoUbicacion, sede);
	}
	
	public static final UbicacionEntity create(final UUID id) {
		return new UbicacionEntity(id, TextHelper.EMPTY, TipoUbicacionEntity.create(), SedeEntity.create());
	}


	public UUID getId() {
		return id;
	}


	public UbicacionEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}


	public String getNombre() {
		return nombre;
	}


	public UbicacionEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}


	public SedeEntity getSede() {
		return sede;
	}


	public UbicacionEntity setSede(final SedeEntity sede) {
		this.sede = ObjectHelper.getDefault(sede, SedeEntity.create());
		return this;
	}
	
	public TipoUbicacionEntity getTipoUbicacion() {
		return tipoUbicacion;
	}


	public UbicacionEntity setTipoUbicacion(final TipoUbicacionEntity tipoUbicacion) {
		this.tipoUbicacion = ObjectHelper.getDefault(tipoUbicacion, TipoUbicacionEntity.create());
		return this;
	}
}
