package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.impl;

import org.springframework.stereotype.Service;



import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.RegisterNewAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.RegisterNewAfiliadoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.register.RegisterNewAfiliado;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewAfiliadoInteractorImpl implements RegisterNewAfiliadoInteractor{
	
	private RegisterNewAfiliado registerNewAfiliado;

	public RegisterNewAfiliadoInteractorImpl(final RegisterNewAfiliado registerNewAfiliado) {
		this.registerNewAfiliado = registerNewAfiliado;
	}

	@Override
	public void execute(final RegisterNewAfiliadoDTO data) {

		var afiliadoDomain = RegisterNewAfiliadoMapper.INSTANCE.toDomain(data);
		registerNewAfiliado.execute(afiliadoDomain);

	}


}
