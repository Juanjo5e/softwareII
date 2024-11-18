package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.update;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoPinRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinFormatoValidoRule;

@Service
public class UpdateAfiliadoPinRulesValidatorImpl implements UpdateAfiliadoPinRulesValidator {

    private final AfiliadoPinNoEsNuloRule afiliadoPinNoEsNuloRule;
    private final AfiliadoPinFormatoValidoRule afiliadoPinFormatoValidoRule;

    public UpdateAfiliadoPinRulesValidatorImpl(
            final AfiliadoPinNoEsNuloRule afiliadoPinNoEsNuloRule,
            final AfiliadoPinFormatoValidoRule afiliadoPinFormatoValidoRule) {
        this.afiliadoPinNoEsNuloRule = afiliadoPinNoEsNuloRule;
        this.afiliadoPinFormatoValidoRule = afiliadoPinFormatoValidoRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        // Validación de que el PIN no sea nulo
        afiliadoPinNoEsNuloRule.validate(data);
        
        // Validación del formato o longitud del PIN
        afiliadoPinFormatoValidoRule.validate(data);
    }
}
