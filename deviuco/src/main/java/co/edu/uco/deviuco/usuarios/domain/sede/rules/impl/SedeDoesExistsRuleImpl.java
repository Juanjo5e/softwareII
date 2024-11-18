package co.edu.uco.deviuco.usuarios.domain.sede.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.sede.SedeRepository;
import co.edu.uco.deviuco.usuarios.domain.sede.rules.SedeDoesExistsRule;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionSedeDoesNotExistsException;

@Service
public class SedeDoesExistsRuleImpl implements SedeDoesExistsRule {

	private final SedeRepository sedeRepository;
	
	public SedeDoesExistsRuleImpl(SedeRepository sedeRepository) {
		this.sedeRepository = sedeRepository;
	}
	
	
	@Override
	public void validate(UUID data) {
		if(!sedeRepository.existsById(data)) {
			throw UbicacionSedeDoesNotExistsException.create();
		}
		
	}

}
