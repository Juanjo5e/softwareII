package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.domain.DomainRule;

@Service
public interface TipoUbicacionIdIsNotNullRule extends DomainRule<UUID>{

}

