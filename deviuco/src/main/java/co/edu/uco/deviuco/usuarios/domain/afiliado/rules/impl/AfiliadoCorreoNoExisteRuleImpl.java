package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoCorreoYaExisteException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoNoExisteRule;

@Service
public class AfiliadoCorreoNoExisteRuleImpl implements AfiliadoCorreoNoExisteRule {

	private final AfiliadoRepository afiliadoRepository;
    private final MessageCatalog messageCatalog;

    
    public AfiliadoCorreoNoExisteRuleImpl(AfiliadoRepository afiliadoRepository, MessageCatalog messageCatalog) {
        this.afiliadoRepository = afiliadoRepository;
        this.messageCatalog= messageCatalog;
    }

    @Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliadoRepository.existsByCorreo(afiliado.getCorreo())) {
            throw AfiliadoCorreoYaExisteException.create(messageCatalog );
        }
    }
}
