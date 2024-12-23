package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.exceptions.TipoIdentificacionIdIsNullException;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionIdIsNotNullRule;
@Service
public class TipoIdentificacionIdIsNotNullRuleImpl implements TipoIdentificacionIdIsNotNullRule {

	private final MessageCatalog messageCatalog;
	

	public TipoIdentificacionIdIsNotNullRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}


	@Override
	public void validate(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw TipoIdentificacionIdIsNullException.create(messageCatalog);
		}
		
	}

}
