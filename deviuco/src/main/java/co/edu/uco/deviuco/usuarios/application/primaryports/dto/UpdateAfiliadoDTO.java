package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class UpdateAfiliadoDTO {
    private UUID tipoIdentificacionId;
    private String numeroIdAfiliado;
    private String correo;
    private String telefono;
    private String pin;
    // Constructor para inicializar solo los campos actualizables
    public UpdateAfiliadoDTO(UUID id, String numeroIdAfiliado, String nombre, String correo, 
                             String telefono, String pin, UUID tipoIdentificacionId) {
       
        this.numeroIdAfiliado = numeroIdAfiliado;
        setCorreo(correo);
        setTelefono(telefono);
        setPin(pin);
        setTipoIdentificacionId(tipoIdentificacionId);
    }

  
    public String getNumeroIdAfiliado() {
        return numeroIdAfiliado;
    }

   

    // Getters y Setters para los campos actualizables
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = TextHelper.applyTrim(correo);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = TextHelper.applyTrim(telefono);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = TextHelper.applyTrim(pin);
    }

    public UUID getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(UUID tipoIdentificacionId) {
        this.tipoIdentificacionId = UUIDHelper.getDefault(tipoIdentificacionId, UUIDHelper.getDefault());
    }
}