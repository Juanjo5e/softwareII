package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoPinRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinFormatoValidoRule;

@Service
public class RegisterNewAfiliadoPinRulesValidatorImpl implements RegisterNewAfiliadoPinRulesValidator {

    private final AfiliadoPinNoEsNuloRule afiliadoPinNoEsNuloRule;
    private final AfiliadoPinFormatoValidoRule afiliadoPinFormatoValidoRule;

    public RegisterNewAfiliadoPinRulesValidatorImpl(
            final AfiliadoPinNoEsNuloRule afiliadoPinNoEsNuloRule,
            final AfiliadoPinFormatoValidoRule afiliadoPinFormatoValidoRule) {
        this.afiliadoPinNoEsNuloRule = afiliadoPinNoEsNuloRule;
        this.afiliadoPinFormatoValidoRule = afiliadoPinFormatoValidoRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        afiliadoPinNoEsNuloRule.validate(data);
        afiliadoPinFormatoValidoRule.validate(data);
    }
} 