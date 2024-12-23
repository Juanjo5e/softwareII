package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoNumeroIdEsNuloException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNumeroIdNoEsNuloRule;

@Service
public class AfiliadoNumeroIdNoEsNuloRuleImpl implements AfiliadoNumeroIdNoEsNuloRule {

	private final MessageCatalog messageCatalog;

    public AfiliadoNumeroIdNoEsNuloRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliado.getNumeroIdAfiliado() == null || afiliado.getNumeroIdAfiliado().trim().isEmpty()) {
            throw AfiliadoNumeroIdEsNuloException.create(messageCatalog);
        }
    }
}
