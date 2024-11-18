package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update;

import co.edu.uco.deviuco.usuarios.application.usecase.RulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

public interface UpdateAfiliadoCorreoRulesValidator extends RulesValidator<AfiliadoDomain> {
    void validate(AfiliadoDomain data);
}
