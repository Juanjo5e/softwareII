package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.UbicacionEntity;
import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.SedeEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.TipoUbicacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacion;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacionRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;
@Service
public class RegisterNewUbicacionImpl implements RegisterNewUbicacion{

	private UbicacionRepository ubicacionRepository;
	private RegisterNewUbicacionRulesValidator registerNewUbicacionRulesValidator;

	public RegisterNewUbicacionImpl(final UbicacionRepository ubicacionRepository,
			final RegisterNewUbicacionRulesValidator registerNewUbicacionRulesValidator) {
		this.ubicacionRepository = ubicacionRepository;
		this.registerNewUbicacionRulesValidator = registerNewUbicacionRulesValidator;
	}

	@Override
	public void execute(final UbicacionDomain domain) {

		// Rules validation
		registerNewUbicacionRulesValidator.validate(domain);

		// DataMapper -> Domain -> Entity
		final var ubicacionEntity = UbicacionEntity.create()
				.setId(domain.getId())
				.setNombre(domain.getNombre())
				.setSede(SedeEntityMapper.INSTANCE.domainToEntity(domain.getSede()))
				.setTipoUbicacion(TipoUbicacionEntityMapper.INSTANCE.domainToEntity(domain.getTipoUbicacion()));

		ubicacionRepository.save(ubicacionEntity);
	}

}