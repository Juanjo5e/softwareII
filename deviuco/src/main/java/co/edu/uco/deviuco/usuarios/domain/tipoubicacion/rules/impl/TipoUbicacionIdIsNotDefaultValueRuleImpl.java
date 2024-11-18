package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.exceptions.TipoUbicacionIdIsDefaultValueException;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules.TipoUbicacionIdIsNotDefaultValueRule;
@Service
public class TipoUbicacionIdIsNotDefaultValueRuleImpl implements TipoUbicacionIdIsNotDefaultValueRule {
	
	private MessageCatalog messageCatalog;
	
	
	public TipoUbicacionIdIsNotDefaultValueRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}


	@Override
	public void validate(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw TipoUbicacionIdIsDefaultValueException.create(messageCatalog);
		}
		
	}

}
