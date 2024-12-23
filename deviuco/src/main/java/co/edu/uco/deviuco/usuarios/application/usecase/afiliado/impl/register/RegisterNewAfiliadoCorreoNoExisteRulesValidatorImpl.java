package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoCorreoNoExisteRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoExisteRule;

@Service
public class RegisterNewAfiliadoCorreoNoExisteRulesValidatorImpl implements RegisterNewAfiliadoCorreoNoExisteRulesValidator {

    private final AfiliadoCorreoNoExisteRule afiliadoCorreoNoExisteRule;

    public RegisterNewAfiliadoCorreoNoExisteRulesValidatorImpl(final AfiliadoCorreoNoExisteRule afiliadoCorreoNoExisteRule) {
        this.afiliadoCorreoNoExisteRule = afiliadoCorreoNoExisteRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        afiliadoCorreoNoExisteRule.validate(data);
    }
} 