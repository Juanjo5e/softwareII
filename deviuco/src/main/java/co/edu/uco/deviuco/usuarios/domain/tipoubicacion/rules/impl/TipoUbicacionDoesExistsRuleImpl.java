package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoubicacion.TipoUbicacionRepository;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.exceptions.TipoUbicacionDoesNotExistsException;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionDoesExistsRule;

@Service
public class TipoUbicacionDoesExistsRuleImpl implements TipoUbicacionDoesExistsRule {

	private final TipoUbicacionRepository tipoUbicacionRepository;
	private final MessageCatalog messageCatalog;
	
	public TipoUbicacionDoesExistsRuleImpl(TipoUbicacionRepository tipoUbicacionRepository, MessageCatalog messageCatalog) {
		this.tipoUbicacionRepository = tipoUbicacionRepository;
		this.messageCatalog = messageCatalog;
	}
	
	
	
	@Override
	public void validate(UUID data) {
		if(!tipoUbicacionRepository.existsById(data)) {
			throw TipoUbicacionDoesNotExistsException.create(messageCatalog);
		}
		
	}

}
