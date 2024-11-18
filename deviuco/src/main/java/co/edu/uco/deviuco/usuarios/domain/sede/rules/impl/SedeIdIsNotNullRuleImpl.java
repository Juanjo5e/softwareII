package co.edu.uco.deviuco.usuarios.domain.sede.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.domain.sede.exceptions.SedeIdIsNullException;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeIdIsNotNullRule;
@Service
public class SedeIdIsNotNullRuleImpl implements SedeIdIsNotNullRule {
	
	@Override
	public void validate(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw SedeIdIsNullException.create();
		}
		
	}

}
