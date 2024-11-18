package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionIdIsNullException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionIdIsNotNullRule;
@Service
public final class UbicacionIdIsNotNullRuleImpl implements UbicacionIdIsNotNullRule {
	
	private MessageCatalog messageCatalog;
	
	
	
	public UbicacionIdIsNotNullRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}



	@Override
	public void validate(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw UbicacionIdIsNullException.create(messageCatalog);
		}
		
	}

}
