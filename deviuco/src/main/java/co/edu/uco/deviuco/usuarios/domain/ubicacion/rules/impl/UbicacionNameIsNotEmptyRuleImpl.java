package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionNameIsEmptyException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameIsNotEmptyRule;
@Service
public class UbicacionNameIsNotEmptyRuleImpl implements UbicacionNameIsNotEmptyRule {
	
	private MessageCatalog messageCatalog;

	public UbicacionNameIsNotEmptyRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(String data) {
		if(TextHelper.isEmpty(data)) {
			throw UbicacionNameIsEmptyException.create(messageCatalog);
		}
		
	}

}
