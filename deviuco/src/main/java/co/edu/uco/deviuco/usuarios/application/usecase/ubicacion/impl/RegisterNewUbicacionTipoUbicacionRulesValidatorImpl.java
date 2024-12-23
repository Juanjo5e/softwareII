package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;


import java.util.UUID;
import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionTipoUbicacionRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionDoesExistsRule;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionIdIsNotDefaultValueRule;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionIdIsNotNullRule;

@Service
public final class RegisterNewUbicacionTipoUbicacionRulesValidatorImpl implements RegisterNewUbicacionTipoUbicacionRulesValidator {

	private TipoUbicacionDoesExistsRule tipoUbicacionDoesExistsRule;
	private TipoUbicacionIdIsNotDefaultValueRule tipoUbicacionIdIsNotDefaultValueRule;
	private TipoUbicacionIdIsNotNullRule tipoUbicacionIdIsNotNullRule;
	
	

	public RegisterNewUbicacionTipoUbicacionRulesValidatorImpl(final TipoUbicacionDoesExistsRule tipoUbicacionDoesExistsRule,
			 final TipoUbicacionIdIsNotDefaultValueRule tipoUbicacionIdIsNotDefaultValueRule, final TipoUbicacionIdIsNotNullRule tipoUbicacionIdIsNotNullRule) {
		super();
		this.tipoUbicacionDoesExistsRule = tipoUbicacionDoesExistsRule;
		this.tipoUbicacionIdIsNotDefaultValueRule = tipoUbicacionIdIsNotDefaultValueRule;
		this.tipoUbicacionIdIsNotNullRule = tipoUbicacionIdIsNotNullRule;
	}
	@Override
	public void validate(final UUID tipoUbicacionid) {
		validateTipoUbicacion(tipoUbicacionid);
				
	}
	
	public void validateTipoUbicacion(final UUID tipoUbicacionid) {
		tipoUbicacionDoesExistsRule.validate(tipoUbicacionid);
		tipoUbicacionIdIsNotDefaultValueRule.validate(tipoUbicacionid);
		tipoUbicacionIdIsNotNullRule.validate(tipoUbicacionid);
		
		
	}


}