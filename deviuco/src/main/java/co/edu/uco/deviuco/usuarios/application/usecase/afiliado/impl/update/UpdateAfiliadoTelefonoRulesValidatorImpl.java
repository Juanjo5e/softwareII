package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.update;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoTelefonoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoFormatoValidoRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoExisteRule;

@Service
public class UpdateAfiliadoTelefonoRulesValidatorImpl implements UpdateAfiliadoTelefonoRulesValidator {

    private final AfiliadoTelefonoNoEsNuloRule afiliadoTelefonoNoEsNuloRule;
    private final AfiliadoTelefonoFormatoValidoRule afiliadoTelefonoFormatoValidoRule;
    private final AfiliadoTelefonoNoExisteRule afiliadoTelefonoNoExisteRule;

    public UpdateAfiliadoTelefonoRulesValidatorImpl(
            final AfiliadoTelefonoNoEsNuloRule afiliadoTelefonoNoEsNuloRule,
            final AfiliadoTelefonoFormatoValidoRule afiliadoTelefonoFormatoValidoRule,
            final AfiliadoTelefonoNoExisteRule afiliadoTelefonoNoExisteRule) {
        this.afiliadoTelefonoNoEsNuloRule = afiliadoTelefonoNoEsNuloRule;
        this.afiliadoTelefonoFormatoValidoRule = afiliadoTelefonoFormatoValidoRule;
        this.afiliadoTelefonoNoExisteRule = afiliadoTelefonoNoExisteRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        // Validación de que el teléfono no sea nulo
        afiliadoTelefonoNoEsNuloRule.validate(data);
        
        // Validación del formato del teléfono
        afiliadoTelefonoFormatoValidoRule.validate(data);
        
        // Validación de que el teléfono no esté en uso por otro afiliado
        afiliadoTelefonoNoExisteRule.validate(data);
    }
}
