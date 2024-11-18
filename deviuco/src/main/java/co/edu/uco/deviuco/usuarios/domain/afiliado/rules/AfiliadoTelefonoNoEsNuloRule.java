package co.edu.uco.deviuco.usuarios.domain.afiliado.rules;

import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

public interface AfiliadoTelefonoNoEsNuloRule {
    void validate(AfiliadoDomain data);
}