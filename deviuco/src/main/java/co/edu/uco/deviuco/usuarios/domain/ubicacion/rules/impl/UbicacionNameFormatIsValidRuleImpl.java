package co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions.UbicacionNameFormatIsNotValidException;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.rules.UbicacionNameFormatIsValidRule;
@Service
public class UbicacionNameFormatIsValidRuleImpl implements UbicacionNameFormatIsValidRule {
	
	private MessageCatalog messageCatalog;

	public UbicacionNameFormatIsValidRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(String data) {
		if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ 0-9]+$")) {
			throw UbicacionNameFormatIsNotValidException.create(messageCatalog);
		}
	}
}
