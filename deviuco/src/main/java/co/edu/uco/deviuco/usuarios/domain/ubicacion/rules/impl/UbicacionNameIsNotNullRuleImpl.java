package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionNameIsNullException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotNullRule;
@Service
public class UbicacionNameIsNotNullRuleImpl implements UbicacionNameIsNotNullRule{

	@Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw UbicacionNameIsNullException.create();
		}

	}

}
