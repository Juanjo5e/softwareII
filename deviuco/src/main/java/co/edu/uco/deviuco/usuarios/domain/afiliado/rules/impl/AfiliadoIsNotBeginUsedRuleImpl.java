package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import java.util.UUID;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIsBeginUsedException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIsNotBeginUsedRule;
@Service
public class AfiliadoIsNotBeginUsedRuleImpl implements AfiliadoIsNotBeginUsedRule {
	
	private AfiliadoRepository afiliadoRepository;
	private final MessageCatalog messageCatalog;


	public AfiliadoIsNotBeginUsedRuleImpl(final AfiliadoRepository afiliadoRepository, final MessageCatalog messageCatalog) {
		this.afiliadoRepository = afiliadoRepository;
		this.messageCatalog = messageCatalog;
	}


	@Override
	public void validate(UUID data) {
		if(afiliadoRepository.isAfiliadoBeingUsed(data)) {
			throw AfiliadoIsBeginUsedException.create(messageCatalog);
		}
	}
}
