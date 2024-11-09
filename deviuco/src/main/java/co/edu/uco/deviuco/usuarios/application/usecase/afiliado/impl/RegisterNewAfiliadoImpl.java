package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;
import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.TipoIdentificacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliado;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RegisterNewAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

@Service
public class RegisterNewAfiliadoImpl implements RegisterNewAfiliado{

	private AfiliadoRepository afiliadoRepository;
	private RegisterNewAfiliadoRulesValidator registerNewAfiliadoRulesValidator;

	public RegisterNewAfiliadoImpl(final AfiliadoRepository afiliadoRepository,
			final RegisterNewAfiliadoRulesValidator registerNewAfiliadoRulesValidator) {
		this.afiliadoRepository = afiliadoRepository;
		this.registerNewAfiliadoRulesValidator = registerNewAfiliadoRulesValidator;
	}

	@Override
	public void execute(final AfiliadoDomain domain) {

		// Rules validation
		registerNewAfiliadoRulesValidator.validate(domain);

		// DataMapper -> Domain -> Entity
		final var afiliadoEntity = AfiliadoEntity.create()
				.setId(domain.getId())
				.setNombre(domain.getNombre())
				.setNumeroIdAfiliado(domain.getNumeroIdAfiliado())
				.setCorreo(domain.getCorreo())
				.setTelefono(domain.getTelefono())
				.setPin(domain.getPin())
				.setTipoIdentificacion(TipoIdentificacionEntityMapper.INSTANCE.domainToEntity(domain.getTipoIdentificacion()));

		afiliadoRepository.save(afiliadoEntity);
	}

}