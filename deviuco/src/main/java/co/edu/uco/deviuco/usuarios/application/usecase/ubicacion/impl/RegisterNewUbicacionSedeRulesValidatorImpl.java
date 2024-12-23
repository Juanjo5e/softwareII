package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;


import java.util.UUID;
import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionSedeRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeDoesExistsRule;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeIdIsNotDefaultValueRule;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeIdIsNotNullRule;

@Service
public final class RegisterNewUbicacionSedeRulesValidatorImpl implements RegisterNewUbicacionSedeRulesValidator {

	private SedeDoesExistsRule sedeDoesExistsRule;
	private SedeIdIsNotDefaultValueRule sedeIdIsNotDefaultValueRule;
	private SedeIdIsNotNullRule sedeIdIsNotNullRule;
	
	

	public RegisterNewUbicacionSedeRulesValidatorImpl(final SedeDoesExistsRule sedeDoesExistsRule,
			 final SedeIdIsNotDefaultValueRule sedeIdIsNotDefaultValueRule, final SedeIdIsNotNullRule sedeIdIsNotNullRule) {
		super();
		this.sedeDoesExistsRule = sedeDoesExistsRule;
		this.sedeIdIsNotDefaultValueRule = sedeIdIsNotDefaultValueRule;
		this.sedeIdIsNotNullRule = sedeIdIsNotNullRule;
	}
	@Override
	public void validate(final UUID sedeid) {
		validateSede(sedeid);
				
	}
	
	public void validateSede(final UUID sedeid) {
		sedeDoesExistsRule.validate(sedeid);
		sedeIdIsNotDefaultValueRule.validate(sedeid);
		sedeIdIsNotNullRule.validate(sedeid);
		
		
	}


}