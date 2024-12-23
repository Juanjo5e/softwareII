package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.impl;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewUbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.RegisterNewUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.RegisterNewUbicacionMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RegisterNewUbicacion;
@Service
@Transactional
public class RegisterNewUbicacionInteractorImpl implements RegisterNewUbicacionInteractor {

	private RegisterNewUbicacion registerNewUbicacion;

	public RegisterNewUbicacionInteractorImpl(final RegisterNewUbicacion registerNewUbicacion) {
		this.registerNewUbicacion = registerNewUbicacion;
	}

	@Override
	public void execute(final RegisterNewUbicacionDTO data) {

		// DataMapper -> DTO -> Domain
		var ubicacionDomain = RegisterNewUbicacionMapper.INSTANCE.toDomain(data);
		registerNewUbicacion.execute(ubicacionDomain);

	}

}
