package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register;

import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

public interface RegisterNewAfiliadoPinRulesValidator {
    void validate(AfiliadoDomain data);
} 