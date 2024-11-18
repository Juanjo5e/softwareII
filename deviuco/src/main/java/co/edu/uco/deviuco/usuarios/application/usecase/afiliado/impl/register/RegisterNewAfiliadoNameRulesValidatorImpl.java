package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoNameRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNameIsNotNullRule;
@Service
public class RegisterNewAfiliadoNameRulesValidatorImpl implements RegisterNewAfiliadoNameRulesValidator {

	private final AfiliadoNameIsNotNullRule afiliadoNameIsNotNullRule;

	public RegisterNewAfiliadoNameRulesValidatorImpl(
			
			final AfiliadoNameIsNotNullRule afiliadoNameIsNotNullRule) {
	
		this.afiliadoNameIsNotNullRule = afiliadoNameIsNotNullRule;
		
	}

	@Override
	public void validate(AfiliadoDomain data) {
		afiliadoNameIsNotNullRule.validate(data.getNombre());
		
	}

}
