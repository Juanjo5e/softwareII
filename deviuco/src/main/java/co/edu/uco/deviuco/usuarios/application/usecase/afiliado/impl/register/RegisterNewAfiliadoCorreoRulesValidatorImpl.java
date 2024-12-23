package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoCorreoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoFormatoValidoRule;

@Service
public class RegisterNewAfiliadoCorreoRulesValidatorImpl implements RegisterNewAfiliadoCorreoRulesValidator {

    private final AfiliadoCorreoNoEsNuloRule afiliadoCorreoNoEsNuloRule;
    private final AfiliadoCorreoFormatoValidoRule afiliadoCorreoFormatoValidoRule;

    public RegisterNewAfiliadoCorreoRulesValidatorImpl(
            final AfiliadoCorreoNoEsNuloRule afiliadoCorreoNoEsNuloRule,
            final AfiliadoCorreoFormatoValidoRule afiliadoCorreoFormatoValidoRule) {
        this.afiliadoCorreoNoEsNuloRule = afiliadoCorreoNoEsNuloRule;
        this.afiliadoCorreoFormatoValidoRule = afiliadoCorreoFormatoValidoRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        afiliadoCorreoNoEsNuloRule.validate(data);
        afiliadoCorreoFormatoValidoRule.validate(data);
    }
} 