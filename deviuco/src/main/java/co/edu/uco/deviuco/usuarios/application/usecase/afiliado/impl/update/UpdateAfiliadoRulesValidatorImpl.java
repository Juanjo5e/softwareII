package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.update;

import org.springframework.stereotype.Service;


import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoCorreoRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoTelefonoRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoPinRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

@Service
public final class UpdateAfiliadoRulesValidatorImpl implements UpdateAfiliadoRulesValidator {

    private final UpdateAfiliadoCorreoRulesValidator updateAfiliadoCorreoRulesValidator;
    private final UpdateAfiliadoTelefonoRulesValidator updateAfiliadoTelefonoRulesValidator;
    private final UpdateAfiliadoPinRulesValidator updateAfiliadoPinRulesValidator;
    

    public UpdateAfiliadoRulesValidatorImpl(
            final UpdateAfiliadoCorreoRulesValidator updateAfiliadoCorreoRulesValidator,
            final UpdateAfiliadoTelefonoRulesValidator updateAfiliadoTelefonoRulesValidator,
            final UpdateAfiliadoPinRulesValidator updateAfiliadoPinRulesValidator
            ) {
        this.updateAfiliadoCorreoRulesValidator = updateAfiliadoCorreoRulesValidator;
        this.updateAfiliadoTelefonoRulesValidator = updateAfiliadoTelefonoRulesValidator;
        this.updateAfiliadoPinRulesValidator = updateAfiliadoPinRulesValidator;
    
    }

    @Override
    public void validate(final AfiliadoDomain data) {
        // Validaciones específicas para los campos actualizables
        updateAfiliadoCorreoRulesValidator.validate(data);
        updateAfiliadoTelefonoRulesValidator.validate(data);
        updateAfiliadoPinRulesValidator.validate(data);
        
        
    }
}
