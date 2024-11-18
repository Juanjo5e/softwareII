package co.edu.uco.deviuco.usuarios.domain.sede.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviuco.usuarios.domain.sede.exceptions.SedeIdIsDefaultValueException;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeIdIsNotDefaultValueRule;

@Service
public class SedeIdIsNotDefaultValueRuleImpl implements SedeIdIsNotDefaultValueRule {
	
	@Override
	public void validate(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw SedeIdIsDefaultValueException.create();
		}
		
	}

}
