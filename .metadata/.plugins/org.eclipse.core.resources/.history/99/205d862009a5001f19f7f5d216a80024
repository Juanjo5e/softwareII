package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoTipoIdentificacionRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionDoesExistsRule;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionIdIsNotDefaultValueRule;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionIdIsNotNullRule;

@Service
public class RegisterNewAfiliadoTipoIdentificacionRulesValidatorImpl implements RegisterNewAfiliadoTipoIdentificacionRulesValidator {

	private TipoIdentificacionDoesExistsRule tipoIdentificacionDoesExistsRule;
	private TipoIdentificacionIdIsNotDefaultValueRule tipoIdentificacionIdIsNotDefaultValueRule;
	private TipoIdentificacionIdIsNotNullRule tipoIdentificacionIdIsNotNullRule;
	
	

	public RegisterNewAfiliadoTipoIdentificacionRulesValidatorImpl(final TipoIdentificacionDoesExistsRule tipoIdentificacionDoesExistsRule,
			 final TipoIdentificacionIdIsNotDefaultValueRule tipoIdentificacionIdIsNotDefaultValueRule, final TipoIdentificacionIdIsNotNullRule tipoIdentificacionIdIsNotNullRule) {
		super();
		this.tipoIdentificacionDoesExistsRule = tipoIdentificacionDoesExistsRule;
		this.tipoIdentificacionIdIsNotDefaultValueRule = tipoIdentificacionIdIsNotDefaultValueRule;
		this.tipoIdentificacionIdIsNotNullRule = tipoIdentificacionIdIsNotNullRule;
	}
	@Override
	public void validate(final UUID tipoIdentificacionid) {
		validateTipoIdentificacion(tipoIdentificacionid);
				
	}
	
	public void validateTipoIdentificacion(final UUID tipoIdentificacionid) {
		tipoIdentificacionDoesExistsRule.validate(tipoIdentificacionid);
		tipoIdentificacionIdIsNotDefaultValueRule.validate(tipoIdentificacionid);
		tipoIdentificacionIdIsNotNullRule.validate(tipoIdentificacionid);
		
		
	}


}

