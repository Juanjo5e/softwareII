package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoPinEsNuloException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinNoEsNuloRule;

@Service
public class AfiliadoPinNoEsNuloRuleImpl implements AfiliadoPinNoEsNuloRule {

	private final MessageCatalog messageCatalog;

    public AfiliadoPinNoEsNuloRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliado.getPin() == null || afiliado.getPin().trim().isEmpty()) {
            throw AfiliadoPinEsNuloException.create(messageCatalog);
        }
    }
}
