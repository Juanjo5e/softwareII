package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class RetrieveTipoUbicacionDTO {
    
    private UUID id; 
    private String nombre;
    
    public RetrieveTipoUbicacionDTO() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }
    
    public RetrieveTipoUbicacionDTO(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }
    
    public static RetrieveTipoUbicacionDTO create(UUID id, String nombre) {
        return new RetrieveTipoUbicacionDTO(id, nombre);
    }
    public static RetrieveTipoUbicacionDTO create () {
		return new RetrieveTipoUbicacionDTO();
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
