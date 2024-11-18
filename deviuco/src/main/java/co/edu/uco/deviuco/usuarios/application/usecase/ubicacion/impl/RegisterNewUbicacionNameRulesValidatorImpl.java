package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionNameRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameFormatIsValidRule;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotEmptyRule;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotEqualsRule;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotNullRule;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameLenghtIsValidRule;
@Service
public final class RegisterNewUbicacionNameRulesValidatorImpl implements RegisterNewUbicacionNameRulesValidator {

	private UbicacionNameLenghtIsValidRule ubicacionNameLengthIsValidRule;
	private UbicacionNameFormatIsValidRule ubicacionNameFormatIsValidRule;
	private UbicacionNameIsNotEmptyRule ubicacionNameIsNotEmptyRule;
	private UbicacionNameIsNotNullRule ubicacionNameIsNotNullRule;
	private UbicacionNameIsNotEqualsRule ubicacionNameIsNotEqualsRule;

	public RegisterNewUbicacionNameRulesValidatorImpl(final UbicacionNameLenghtIsValidRule ubicacionNameLengthIsValidRule,
			final UbicacionNameFormatIsValidRule ubicacionNameFormatIsValidRule,
			final UbicacionNameIsNotEmptyRule ubicacionNameIsNotEmptyRule, final UbicacionNameIsNotNullRule ubicacionNameIsNotNullRule, final UbicacionNameIsNotEqualsRule ubicacionNameIsNotEqualsRule ) {
		super();
		this.ubicacionNameLengthIsValidRule = ubicacionNameLengthIsValidRule;
		this.ubicacionNameFormatIsValidRule = ubicacionNameFormatIsValidRule;
		this.ubicacionNameIsNotEmptyRule = ubicacionNameIsNotEmptyRule;
		this.ubicacionNameIsNotNullRule = ubicacionNameIsNotNullRule;
		this.ubicacionNameIsNotEqualsRule =  ubicacionNameIsNotEqualsRule ;
	}

	@Override
	public void validate(UbicacionDomain data) {
		ubicacionNameIsNotNullRule.validate(data.getNombre());
		ubicacionNameIsNotEmptyRule.validate(data.getNombre());
		ubicacionNameLengthIsValidRule.validate(data.getNombre());
		ubicacionNameFormatIsValidRule.validate(data.getNombre());
		ubicacionNameIsNotEqualsRule.validate(data.getNombre());
	}

}
