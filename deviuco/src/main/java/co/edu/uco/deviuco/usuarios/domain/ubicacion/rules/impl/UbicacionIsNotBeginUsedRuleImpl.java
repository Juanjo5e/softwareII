package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionIsBeginUsedException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionIsNotBeginUsedRule;
@Service
public class UbicacionIsNotBeginUsedRuleImpl implements UbicacionIsNotBeginUsedRule {
	
	private UbicacionRepository ubicacionRepository;
	private MessageCatalog messageCatalog;

	public UbicacionIsNotBeginUsedRuleImpl(final UbicacionRepository ubicacionRepository) {
		this.ubicacionRepository = ubicacionRepository;
	}


	@Override
	public void validate(UUID data) {
		if(ubicacionRepository.isUbicacionBeingUsed(data)) {
			throw UbicacionIsBeginUsedException.create(messageCatalog);
		}
	}
}
