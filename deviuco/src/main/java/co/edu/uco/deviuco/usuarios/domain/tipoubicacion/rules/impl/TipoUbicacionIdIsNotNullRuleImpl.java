package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.exceptions.TipoUbicacionIdIsNullException;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionIdIsNotNullRule;
@Service
public class TipoUbicacionIdIsNotNullRuleImpl implements TipoUbicacionIdIsNotNullRule {
	
	private MessageCatalog messageCatalog;
	
	public TipoUbicacionIdIsNotNullRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw TipoUbicacionIdIsNullException.create(messageCatalog);
		}
		
	}

}
