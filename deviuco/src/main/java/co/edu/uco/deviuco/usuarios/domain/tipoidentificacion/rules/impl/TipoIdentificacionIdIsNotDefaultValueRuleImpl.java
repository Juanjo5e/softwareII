package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.exceptions.TipoIdentificacionIdIsDefaultValueException;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.rules.TipoIdentificacionIdIsNotDefaultValueRule;
@Service
public class TipoIdentificacionIdIsNotDefaultValueRuleImpl implements TipoIdentificacionIdIsNotDefaultValueRule {
	
private final MessageCatalog messageCatalog;
	
	public TipoIdentificacionIdIsNotDefaultValueRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw TipoIdentificacionIdIsDefaultValueException.create(messageCatalog);
		}
		
	}

}
