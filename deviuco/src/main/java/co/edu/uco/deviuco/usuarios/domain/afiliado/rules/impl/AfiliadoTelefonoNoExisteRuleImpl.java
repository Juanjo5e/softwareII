package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoTelefonoYaExisteException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoNoExisteRule;

@Service
public class AfiliadoTelefonoNoExisteRuleImpl implements AfiliadoTelefonoNoExisteRule {

	 private final AfiliadoRepository afiliadoRepository;
	    private final MessageCatalog messageCatalog;

	    
	    public AfiliadoTelefonoNoExisteRuleImpl(AfiliadoRepository afiliadoRepository, final MessageCatalog messageCatalog) {
	        this.afiliadoRepository = afiliadoRepository;
	        this.messageCatalog = messageCatalog;
	    }

	    @Override
	    public void validate(AfiliadoDomain afiliado) {
	        if (afiliadoRepository.existsByTelefono(afiliado.getTelefono())) {
	            throw AfiliadoTelefonoYaExisteException.create(messageCatalog);
	        }
	    }
}
