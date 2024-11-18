package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoNameIsNullException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNameIsNotNullRule;

@Service
public class AfiliadoNameIsNotNullRuleImpl implements AfiliadoNameIsNotNullRule {

	private final MessageCatalog messageCatalog;

	public AfiliadoNameIsNotNullRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw AfiliadoNameIsNullException.create(messageCatalog);
		}
	}
}
