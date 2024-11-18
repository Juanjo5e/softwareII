package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionIdDoesExistsRule;
@Service
public final class UbicacionIdDoesExistsRuleImpl implements UbicacionIdDoesExistsRule {
	
	private UbicacionRepository ubicacionRepository;
	private MessageCatalog messageCatalog;
	
	public UbicacionIdDoesExistsRuleImpl(UbicacionRepository ubicacionRepository, MessageCatalog messageCatalog ) {
		this.ubicacionRepository = ubicacionRepository;
		this.messageCatalog = messageCatalog;
	}
	

	@Override
	public void validate(final UUID data) {
		if(!ubicacionRepository.existsById(data)) {
			throw UbicacionIdDoesExistsException.create(messageCatalog);
			
		}
		
	}

}
