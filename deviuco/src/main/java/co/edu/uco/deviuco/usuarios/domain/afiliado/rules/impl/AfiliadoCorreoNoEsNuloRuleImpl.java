package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoCorreoEsNuloException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoEsNuloRule;

@Service
public class AfiliadoCorreoNoEsNuloRuleImpl implements AfiliadoCorreoNoEsNuloRule {
	
    private final MessageCatalog messageCatalog;
	
	public AfiliadoCorreoNoEsNuloRuleImpl(AfiliadoRepository afiliadoRepository, MessageCatalog messageCatalog ) {
        this.messageCatalog= messageCatalog;
    }

    @Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliado.getCorreo() == null || afiliado.getCorreo().trim().isEmpty()) {
            throw AfiliadoCorreoEsNuloException.create(messageCatalog);
        }
    }
}
