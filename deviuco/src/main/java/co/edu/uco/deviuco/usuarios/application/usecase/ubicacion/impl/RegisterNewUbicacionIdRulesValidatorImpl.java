package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionIdRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionIdDoesNotExistsRule;



@Service
public final class RegisterNewUbicacionIdRulesValidatorImpl implements RegisterNewUbicacionIdRulesValidator {

	private UbicacionIdDoesNotExistsRule ubicacionIdDoesNotExistRule;

	public RegisterNewUbicacionIdRulesValidatorImpl(final UbicacionIdDoesNotExistsRule ubicacionIdDoesNotExistRule) {
		super();
		this.ubicacionIdDoesNotExistRule = ubicacionIdDoesNotExistRule;
	}


	@Override
	public void validate(UbicacionDomain data) {
		data.generateId();
		try {
			ubicacionIdDoesNotExistRule.validate(data.getId());
		} catch (final UbicacionIdDoesExistsException exception) {
			validate(data);
		}
	}
	
}