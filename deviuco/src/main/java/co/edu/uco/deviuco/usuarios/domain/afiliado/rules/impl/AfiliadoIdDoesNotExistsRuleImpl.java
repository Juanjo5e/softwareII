package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesNotExistsException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIdDoesNotExistsRule;

@Service
public class AfiliadoIdDoesNotExistsRuleImpl implements AfiliadoIdDoesNotExistsRule {
    
	private final AfiliadoRepository afiliadoRepository;
    private final MessageCatalog messageCatalog;
    
    public AfiliadoIdDoesNotExistsRuleImpl(final AfiliadoRepository afiliadoRepository, final MessageCatalog messageCatalog) {
        this.afiliadoRepository = afiliadoRepository;
        this.messageCatalog = messageCatalog;
    }

    @Override
    public void validate(final UUID data) {
        if(afiliadoRepository.existsById(data)) {
            throw AfiliadoIdDoesNotExistsException.create(messageCatalog);
        }
    }
}
