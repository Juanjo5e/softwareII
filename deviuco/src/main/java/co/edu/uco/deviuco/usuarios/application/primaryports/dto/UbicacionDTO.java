package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class UbicacionDTO {
	private UUID id;
	private String nombre;
	private TipoUbicacionDTO tipoUbicacion;
	private SedeDTO sede;
	
	public UbicacionDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setTipoUbicacion(new TipoUbicacionDTO());
		setSede(new SedeDTO());
	}
	
	
	
	public UbicacionDTO(UUID id, String nombre, TipoUbicacionDTO tipo, SedeDTO sede) {
		setId(id);
		setNombre(nombre);
		setTipoUbicacion(tipoUbicacion);
		setSede(sede);
	}
	
	public static UbicacionDTO create () {
		return new UbicacionDTO();
		
	}
	public static UbicacionDTO create(UUID id, String nombre, TipoUbicacionDTO tipoUbicacion, SedeDTO sede) {
		return new UbicacionDTO(id, nombre, tipoUbicacion, sede);
		
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
	public TipoUbicacionDTO getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(TipoUbicacionDTO tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }
    
    public SedeDTO getSede() {
        return sede;
    }

    public void setSede(SedeDTO sede) {
        this.sede= sede;
    }

}


	