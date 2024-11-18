package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.update;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoCorreoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoFormatoValidoRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoExisteRule;

@Service
public class UpdateAfiliadoCorreoRulesValidatorImpl implements UpdateAfiliadoCorreoRulesValidator {

    private final AfiliadoCorreoNoEsNuloRule afiliadoCorreoNoEsNuloRule;
    private final AfiliadoCorreoFormatoValidoRule afiliadoCorreoFormatoValidoRule;
    private final AfiliadoCorreoNoExisteRule afiliadoCorreoNoExisteRule;

    public UpdateAfiliadoCorreoRulesValidatorImpl(
            final AfiliadoCorreoNoEsNuloRule afiliadoCorreoNoEsNuloRule,
            final AfiliadoCorreoFormatoValidoRule afiliadoCorreoFormatoValidoRule,
            final AfiliadoCorreoNoExisteRule afiliadoCorreoNoExisteRule) {
        this.afiliadoCorreoNoEsNuloRule = afiliadoCorreoNoEsNuloRule;
        this.afiliadoCorreoFormatoValidoRule = afiliadoCorreoFormatoValidoRule;
        this.afiliadoCorreoNoExisteRule = afiliadoCorreoNoExisteRule;
    }

    @Override
    public void validate(AfiliadoDomain data) {
        // Validación de que el correo no sea nulo
        afiliadoCorreoNoEsNuloRule.validate(data);
        
        // Validación del formato del correo
        afiliadoCorreoFormatoValidoRule.validate(data);
        
        // Validación de que el correo no esté en uso por otro afiliado
        afiliadoCorreoNoExisteRule.validate(data);
    }
}
