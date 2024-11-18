package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdIsNullException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIdIsNotNullRule;
@Service
public class AfiliadoIdIsNotNullRuleImpl implements AfiliadoIdIsNotNullRule {

	private final MessageCatalog messageCatalog;

	public AfiliadoIdIsNotNullRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw AfiliadoIdIsNullException.create(messageCatalog);
		}
		
	}

}

