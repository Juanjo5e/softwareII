package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register;

import co.edu.uco.deviuco.usuarios.application.usecase.RulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

public interface RegisterNewAfiliadoIdRulesValidator extends RulesValidator<AfiliadoDomain> {
    void validate(AfiliadoDomain data);
}
