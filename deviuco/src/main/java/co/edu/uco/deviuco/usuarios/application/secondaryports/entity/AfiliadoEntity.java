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
@Table (name = "afiliado")
public final class AfiliadoEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column (name = "numeroidafiliado")
	private String numeroIdAfiliado;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "correo")
	private String correo;
	
	@Column (name = "telefono")
	private String telefono;
	
	@Column (name = "pin")
	private String pin;
	
	@ManyToOne
	@JoinColumn(name= "tipo_identificacion_id")
	private TipoIdentificacionEntity tipoIdentificacion;
	
	AfiliadoEntity() {
		setId(UUIDHelper.getDefault());
		setNumeroIdAfiliado(TextHelper.EMPTY);
		setNombre(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(TextHelper.EMPTY);
		setPin(TextHelper.EMPTY);
		setTipoIdentificacion(TipoIdentificacionEntity.create());
	}


	public AfiliadoEntity(UUID id, String numeroIdAfiliado, String nombre, String correo, String telefono,String pin,TipoIdentificacionEntity tipoIdentificacion) {
		setId(id);
		setNumeroIdAfiliado(numeroIdAfiliado);
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
		setPin(pin);
		setTipoIdentificacion(tipoIdentificacion);
	}
	
	public static final AfiliadoEntity create() {
		return new AfiliadoEntity();
	}
	
	
	public static final AfiliadoEntity create(final UUID id,final String numeroIdAfiliado, final String nombre, final String correo, final String telefono
			, final String pin, final TipoIdentificacionEntity tipoIdentificacion) {
		return new AfiliadoEntity(id, numeroIdAfiliado, nombre, correo, telefono, pin, tipoIdentificacion);
	}
	
	public static final AfiliadoEntity create(final UUID id) {
		return new AfiliadoEntity(id, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TipoIdentificacionEntity.create());
	}


	public UUID getId() {
		return id;
	}


	public AfiliadoEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}



	public AfiliadoEntity setNumeroIdAfiliado(final String numeroIdAfiliado) {
		this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
		return this;
	}
	
	public String getNumeroIdAfiliado() {
		return numeroIdAfiliado;
	}


	public AfiliadoEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public String getNombre() {
		return nombre;
	}


	public AfiliadoEntity setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
		return this;
	}

	public String getCorreo() {
		return correo;
	}


	public AfiliadoEntity setTelefono(final String telefono) {
		this.telefono = TextHelper.applyTrim(telefono);
		return this;
	}

	public String getTelefono() {
		return telefono;
	}


	public AfiliadoEntity setPin(final String pin) {
		this.pin = TextHelper.applyTrim(pin);
		return this;
	}

	public String getPin() {
		return pin;
	}


	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public AfiliadoEntity setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getDefault(tipoIdentificacion, TipoIdentificacionEntity.create());
		return this;
	}
	

}