package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class DeleteAfiliadoDTO {
    private UUID tipoIdentificacionId;
    private String numeroIdAfiliado;

    // Constructor para inicializar solo los campos necesarios para eliminar
    public DeleteAfiliadoDTO(UUID tipoIdentificacionId, String numeroIdAfiliado) {
        setTipoIdentificacionId(tipoIdentificacionId);
        setNumeroIdAfiliado(numeroIdAfiliado);
    }

    // Getters y Setters
    public UUID getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(UUID tipoIdentificacionId) {
        this.tipoIdentificacionId = UUIDHelper.getDefault(tipoIdentificacionId, UUIDHelper.getDefault());
    }

    public String getNumeroIdAfiliado() {
    	return numeroIdAfiliado;
    }

    public void setNumeroIdAfiliado(String numeroIdAfiliado) {
        this.numeroIdAfiliado = numeroIdAfiliado;
    }
}