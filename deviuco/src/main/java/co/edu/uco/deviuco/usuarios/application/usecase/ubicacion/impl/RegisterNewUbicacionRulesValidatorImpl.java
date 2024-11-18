package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionIdRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionNameRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionSedeRulesValidator;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionTipoUbicacionRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;

@Service
public final class RegisterNewUbicacionRulesValidatorImpl implements RegisterNewUbicacionRulesValidator {
	
	private RegisterNewUbicacionIdRulesValidator registerNewUbicacionIdRulesValidator;
	private RegisterNewUbicacionNameRulesValidator registerNewUbicacionNameRulesValidator;
	private RegisterNewUbicacionSedeRulesValidator registerNewUbicacionSedeRulesValidator;
	private RegisterNewUbicacionTipoUbicacionRulesValidator registerNewUbicacionTipoUbicacionRulesValidator;
	

	public RegisterNewUbicacionRulesValidatorImpl(final RegisterNewUbicacionIdRulesValidator registerNewUbicacionIdRulesValidator,
			final RegisterNewUbicacionNameRulesValidator registerNewUbicacionNameRulesValidator,
			final RegisterNewUbicacionSedeRulesValidator registerNewUbicacionSedeRulesValidator,
			final RegisterNewUbicacionTipoUbicacionRulesValidator registerNewUbicacionTipoUbicacionRulesValidator) {
		this.registerNewUbicacionIdRulesValidator = registerNewUbicacionIdRulesValidator;
		this.registerNewUbicacionNameRulesValidator = registerNewUbicacionNameRulesValidator;
		this.registerNewUbicacionSedeRulesValidator = registerNewUbicacionSedeRulesValidator;
		this.registerNewUbicacionTipoUbicacionRulesValidator = registerNewUbicacionTipoUbicacionRulesValidator;
	}


	@Override
	public void validate(final UbicacionDomain data) {
		registerNewUbicacionIdRulesValidator.validate(data);
		registerNewUbicacionNameRulesValidator.validate(data);
		registerNewUbicacionSedeRulesValidator.validate(data.getSede().getId());
		registerNewUbicacionTipoUbicacionRulesValidator.validate(data.getTipoUbicacion().getId());

	}

}
