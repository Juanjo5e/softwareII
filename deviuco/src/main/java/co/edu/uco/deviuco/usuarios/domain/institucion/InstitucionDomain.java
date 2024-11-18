package co.edu.uco.deviuco.usuarios.domain.institucion;

import java.util.UUID;
import co.edu.uco.deviuco.usuarios.domain.Domain;

public class InstitucionDomain extends Domain {
    private String nombre;
  

    public InstitucionDomain(UUID id, String nombre) {
        super(id);
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
 