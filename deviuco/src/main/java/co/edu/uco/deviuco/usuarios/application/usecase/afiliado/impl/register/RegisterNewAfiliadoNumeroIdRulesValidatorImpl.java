package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoNumeroIdRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNumeroIdNoEsNuloRule;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNumeroIdFormatoValidoRule;

@Service
public class RegisterNewAfiliadoNumeroIdRulesValidatorImpl implements RegisterNewAfiliadoNumeroIdRulesValidator {

	private final AfiliadoNumeroIdNoEsNuloRule afiliadoNumeroIdNoEsNuloRule;
	private final AfiliadoNumeroIdFormatoValidoRule afiliadoNumeroIdFormatoValidoRule;

	public RegisterNewAfiliadoNumeroIdRulesValidatorImpl(
			final AfiliadoNumeroIdNoEsNuloRule afiliadoNumeroIdNoEsNuloRule,
			final AfiliadoNumeroIdFormatoValidoRule afiliadoNumeroIdFormatoValidoRule) {
		this.afiliadoNumeroIdNoEsNuloRule = afiliadoNumeroIdNoEsNuloRule;
		this.afiliadoNumeroIdFormatoValidoRule = afiliadoNumeroIdFormatoValidoRule;
	}

	@Override
	public void validate(AfiliadoDomain data) {
		afiliadoNumeroIdNoEsNuloRule.validate(data);
		afiliadoNumeroIdFormatoValidoRule.validate(data);
	}
}