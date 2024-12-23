package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import java.util.UUID;



import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIdDoesExistsRule;
@Service
public class AfiliadoIdDoesExistsRuleImpl implements AfiliadoIdDoesExistsRule {
	
	private final AfiliadoRepository afiliadoRepository;
	private final MessageCatalog messageCatalog;


	public AfiliadoIdDoesExistsRuleImpl(final AfiliadoRepository afiliadoRepository, final MessageCatalog messageCatalog) {
		this.afiliadoRepository = afiliadoRepository;
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(final UUID data) {
		if(!afiliadoRepository.existsById(data)) {
			throw AfiliadoIdDoesExistsException.create(messageCatalog);
			
		}
		
	}

}
