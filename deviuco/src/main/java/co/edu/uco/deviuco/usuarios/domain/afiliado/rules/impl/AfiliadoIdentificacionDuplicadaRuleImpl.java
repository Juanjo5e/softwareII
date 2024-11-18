package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdentificacionDuplicadaException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoIdentificacionDuplicadaRule;

@Service
public class AfiliadoIdentificacionDuplicadaRuleImpl implements AfiliadoIdentificacionDuplicadaRule {

	private final AfiliadoRepository afiliadoRepository;
    private final MessageCatalog messageCatalog;

    public AfiliadoIdentificacionDuplicadaRuleImpl(AfiliadoRepository afiliadoRepository, MessageCatalog messageCatalog ) {
        this.afiliadoRepository = afiliadoRepository;
        this.messageCatalog= messageCatalog;
    }

    @Override
    public void validate(AfiliadoDomain afiliado) {
        if (afiliadoRepository.existsByTipoIdentificacionIdAndNumeroIdAfiliado(
                afiliado.getTipoIdentificacion().getId(), 
                afiliado.getNumeroIdAfiliado())) {
            throw AfiliadoIdentificacionDuplicadaException.create(messageCatalog);
        }
    }
}
