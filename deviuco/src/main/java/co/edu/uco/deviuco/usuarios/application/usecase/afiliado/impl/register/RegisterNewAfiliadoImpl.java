package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.register;

import org.springframework.stereotype.Service;


import co.edu.uco.deviuco.usuarios.application.secondaryports.emailsender.NotificationInteractor;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;
import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.TipoIdentificacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliado;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

@Service
public class RegisterNewAfiliadoImpl implements RegisterNewAfiliado {

	private final AfiliadoRepository afiliadoRepository;
	private final RegisterNewAfiliadoRulesValidator registerNewAfiliadoRulesValidator;
	private final NotificationInteractor notificationInteractor;

	public RegisterNewAfiliadoImpl(
			final AfiliadoRepository afiliadoRepository,
			final RegisterNewAfiliadoRulesValidator registerNewAfiliadoRulesValidator,
			final NotificationInteractor notificationInteractor) {
		this.afiliadoRepository = afiliadoRepository;
		this.registerNewAfiliadoRulesValidator = registerNewAfiliadoRulesValidator;
		this.notificationInteractor = notificationInteractor;
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

		// Guardar el afiliado
		afiliadoRepository.save(afiliadoEntity);

		// Enviar correo de confirmación
		notificationInteractor.notifyAfiliadoRegistration(domain.getCorreo(), domain.getNombre());
	}

}