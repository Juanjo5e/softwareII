package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class RetriveTipoIdentificacionDTO {
    
    private UUID id; 
    private String nombre;
    
    public RetriveTipoIdentificacionDTO() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }
    
    public RetriveTipoIdentificacionDTO(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }
    
    public static RetriveTipoIdentificacionDTO create(UUID id, String nombre) {
        return new RetriveTipoIdentificacionDTO(id, nombre);
    }
    public static RetriveTipoIdentificacionDTO create () {
		return new RetriveTipoIdentificacionDTO();
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
}
