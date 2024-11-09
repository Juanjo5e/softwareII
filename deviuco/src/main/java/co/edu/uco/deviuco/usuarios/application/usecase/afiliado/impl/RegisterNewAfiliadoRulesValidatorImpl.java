package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoIdRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoNameRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoTipoIdentificacionRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
@Service
public final class RegisterNewAfiliadoRulesValidatorImpl implements RegisterNewAfiliadoRulesValidator {
	
	private RegisterNewAfiliadoIdRulesValidator registerNewAfiliadoIdRulesValidator;
	private RegisterNewAfiliadoNameRulesValidator registerNewAfiliadoNameRulesValidator;
	private RegisterNewAfiliadoTipoIdentificacionRulesValidator registerNewAfiliadoTipoIdentificacionRulesValidator;
	

	public RegisterNewAfiliadoRulesValidatorImpl(final RegisterNewAfiliadoIdRulesValidator registerNewAfiliadoIdRulesValidator,
			final RegisterNewAfiliadoNameRulesValidator registerNewAfiliadoNameRulesValidator,
			final RegisterNewAfiliadoTipoIdentificacionRulesValidator registerNewAfiliadoStateRulesValidator) {
		this.registerNewAfiliadoIdRulesValidator = registerNewAfiliadoIdRulesValidator;
		this.registerNewAfiliadoNameRulesValidator = registerNewAfiliadoNameRulesValidator;
		this.registerNewAfiliadoTipoIdentificacionRulesValidator = registerNewAfiliadoTipoIdentificacionRulesValidator;
	}


	@Override
	public void validate(final AfiliadoDomain data) {
		registerNewAfiliadoIdRulesValidator.validate(data);
		registerNewAfiliadoNameRulesValidator.validate(data);
		registerNewAfiliadoTipoIdentificacionRulesValidator.validate(data.getTipoIdentificacion().getId());

	}

}
