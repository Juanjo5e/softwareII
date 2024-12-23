package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoidentificacion.TipoIdentificacionRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoTipoIdentificacionDoesNotExistsException;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionDoesExistsRule;

@Service
public class TipoIdentificacionDoesExistsRuleImpl implements TipoIdentificacionDoesExistsRule {

	private final TipoIdentificacionRepository tipoIdentificacionRepository;
	private final MessageCatalog messageCatalog;
	
	public TipoIdentificacionDoesExistsRuleImpl(TipoIdentificacionRepository tipoIdentificacionRepository, MessageCatalog messageCatalog) {
		this.tipoIdentificacionRepository = tipoIdentificacionRepository;
		this.messageCatalog= messageCatalog;
	}
	
	
	
	@Override
	public void validate(UUID data) {
		if(!tipoIdentificacionRepository.existsById(data)) {
			throw AfiliadoTipoIdentificacionDoesNotExistsException.create(messageCatalog);
		}
		
	}


}
