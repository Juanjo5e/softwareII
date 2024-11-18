package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionIdDoesNotExistsException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionIdDoesNotExistsRule;
@Service
public class UbicacionIdDoesNotExistsRuleImpl implements UbicacionIdDoesNotExistsRule{
	
	private UbicacionRepository ubicacionRepository;
	private MessageCatalog messageCatalog;
	
	public UbicacionIdDoesNotExistsRuleImpl(UbicacionRepository ubicacionRepository, MessageCatalog messageCatalog) {
		this.ubicacionRepository = ubicacionRepository;
	}

	@Override
	public void validate(final UUID data) {
		if(ubicacionRepository.existsById(data)) {
			throw UbicacionIdDoesNotExistsException.create(messageCatalog);
			
		}
		
	}

}
