package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.domain.Domain;

public final class TipoIdentificacionDomain extends Domain {
    private String nombre;

    public TipoIdentificacionDomain(final UUID id, final String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}

