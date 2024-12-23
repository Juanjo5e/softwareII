package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoTelefonoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoFormatoValidoRule;

@Service
public class RegisterNewAfiliadoTelefonoRulesValidatorImpl implements RegisterNewAfiliadoTelefonoRulesValidator {

    private final AfiliadoTelefonoNoEsNuloRule afiliadoTelefonoNoEsNuloRule;
    private final AfiliadoTelefonoFormatoValidoRule afiliadoTelefonoFormatoValidoRule;

    public RegisterNewAfiliadoTelefonoRulesValidatorImpl(
            final AfiliadoTelefonoNoEsNuloRule afiliadoTelefonoNoEsNuloRule,
            final AfiliadoTelefonoFormatoValidoRule afiliadoTelefonoFormatoValidoRule) {
        this.afiliadoTelefonoNoEsNuloRule = afiliadoTelefonoNoEsNuloRule;
        this.afiliadoTelefonoFormatoValidoRule = afiliadoTelefonoFormatoValidoRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        afiliadoTelefonoNoEsNuloRule.validate(data);
        afiliadoTelefonoFormatoValidoRule.validate(data);
    }
}