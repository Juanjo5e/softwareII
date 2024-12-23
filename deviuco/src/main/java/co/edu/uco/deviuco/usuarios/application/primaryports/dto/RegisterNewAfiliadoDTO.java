package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;


import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public final class RegisterNewAfiliadoDTO {
    private String numeroIdAfiliado;
    private String nombre;
    private String correo;
    private String telefono;
    private String pin;
    private UUID tipoIdentificacionId;

    public RegisterNewAfiliadoDTO(final String numeroIdAfiliado, final String nombre, final String correo, 
                                  final String telefono, final String pin, final UUID tipoIdentificacionId) {
        setNumeroIdAfiliado(numeroIdAfiliado);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setPin(pin);
        setTipoIdentificacionId(tipoIdentificacionId);
        
    }

    public static RegisterNewAfiliadoDTO create(final String numeroIdAfiliado, final String nombre, 
                                                final String correo, final String telefono, final String pin, 
                                                final UUID tipoIdentificacionId) {
        return new RegisterNewAfiliadoDTO(numeroIdAfiliado, nombre, correo, telefono, pin, tipoIdentificacionId);
    }

    public String getNumeroIdAfiliado() {
        return numeroIdAfiliado;
    }

    public void setNumeroIdAfiliado(String numeroIdAfiliado) {
        this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

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

    public UUID getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(UUID tipoIdentificacionId) {
        this.tipoIdentificacionId = UUIDHelper.getDefault(tipoIdentificacionId, UUIDHelper.getDefault());
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = TextHelper.applyTrim(pin);
    }
}
