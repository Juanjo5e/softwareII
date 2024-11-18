package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoIdRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIdDoesNotExistsRule;

@Service
public class RegisterNewAfiliadoIdRulesValidatorImpl implements RegisterNewAfiliadoIdRulesValidator {
    private final AfiliadoIdDoesNotExistsRule afiliadoIdDoesNotExistRule;

    public RegisterNewAfiliadoIdRulesValidatorImpl(final AfiliadoIdDoesNotExistsRule afiliadoIdDoesNotExistRule) {
        this.afiliadoIdDoesNotExistRule = afiliadoIdDoesNotExistRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        data.generateId();
        try {
            afiliadoIdDoesNotExistRule.validate(data.getId());
        } catch (final AfiliadoIdDoesExistsException exception) {
            validate(data);
        }
    }
} 