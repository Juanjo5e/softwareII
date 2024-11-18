package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionNameIsEqualsException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotEqualsRule;

@Service
public class UbicacionNameIsNotEqualsRuleImpl implements UbicacionNameIsNotEqualsRule {
	
	private UbicacionRepository ubicacionRepository;
	
	public UbicacionNameIsNotEqualsRuleImpl(UbicacionRepository ubicacionRepository) {
		this.ubicacionRepository = ubicacionRepository;
	}

	@Override
	public void validate(String data) {
		if(ubicacionRepository.existsByNameIgnoreCase(data)) {
			throw UbicacionNameIsEqualsException.create();
		}
		
	}

}
