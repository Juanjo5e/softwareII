package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionNameLenghtIsNotValidException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameLenghtIsValidRule;

@Service
public class UbicacionNameLenghtIsValidRuleImpl implements UbicacionNameLenghtIsValidRule {

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 60;

	@Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw UbicacionNameLenghtIsNotValidException.create();
		}

	}
}
