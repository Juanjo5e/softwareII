package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoTelefonoEsNuloException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoEsNuloRule;

@Service
public class AfiliadoTelefonoNoEsNuloRuleImpl implements AfiliadoTelefonoNoEsNuloRule{

	private final MessageCatalog messageCatalog;

    public AfiliadoTelefonoNoEsNuloRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliado.getTelefono() == null || afiliado.getTelefono().trim().isEmpty()) {
            throw AfiliadoTelefonoEsNuloException.create(messageCatalog);
        }
    }
}
