package co.edu.uco.deviuco.usuarios.domain.afiliado;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.domain.Domain;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;

public class AfiliadoDomain extends Domain {
    private String numeroIdAfiliado;
    private String nombre;
    private String correo;
    private String telefono;
    private String pin;
    private TipoIdentificacionDomain tipoIdentificacion;

    public AfiliadoDomain(UUID id, String numeroIdAfiliado, String nombre, String correo, 
                          String telefono, String pin, TipoIdentificacionDomain tipoIdentificacion) {
        super(id);
        setNumeroIdAfiliado(numeroIdAfiliado);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setPin(pin);
        setTipoIdentificacion(tipoIdentificacion);
    }

    public String getNumeroIdAfiliado() {
        return numeroIdAfiliado;
    }

    private void setNumeroIdAfiliado(String numeroIdAfiliado) {
        this.numeroIdAfiliado = numeroIdAfiliado;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPin() {
        return pin;
    }

    private void setPin(String pin) {
        this.pin = pin;
    }

    public TipoIdentificacionDomain getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    private void setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
}