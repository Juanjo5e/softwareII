package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoTelefonoNoExisteRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoExisteRule;

@Service
public class RegisterNewAfiliadoTelefonoNoExisteRulesValidatorImpl implements RegisterNewAfiliadoTelefonoNoExisteRulesValidator {

    private final AfiliadoTelefonoNoExisteRule afiliadoTelefonoNoExisteRule;

    public RegisterNewAfiliadoTelefonoNoExisteRulesValidatorImpl(final AfiliadoTelefonoNoExisteRule afiliadoTelefonoNoExisteRule) {
        this.afiliadoTelefonoNoExisteRule = afiliadoTelefonoNoExisteRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        afiliadoTelefonoNoExisteRule.validate(data);
    }
} 