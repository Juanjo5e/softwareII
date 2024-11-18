package co.edu.uco.deviuco.usuarios.domain.tipoubicacion;


import java.util.UUID;
import co.edu.uco.deviuco.usuarios.domain.Domain;

public final class TipoUbicacionDomain extends Domain {
    private String nombre;

    public TipoUbicacionDomain(final UUID id, final String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}

