package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.impl;



import java.util.List;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.AfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.RetrieveAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.AfiliadoDtoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RetrieveAfiliado;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RetrieveAfiliadoInteractorImpl implements RetrieveAfiliadoInteractor {
	
	public RetrieveAfiliado retrieveAfiliado;
	
	public RetrieveAfiliadoInteractorImpl (RetrieveAfiliado retrieveAfiliado) {
		this.retrieveAfiliado = retrieveAfiliado;
	}

	@Override
	public List<AfiliadoDTO> execute(AfiliadoDTO data) {
		var afiliadoDomain = AfiliadoDtoMapper.INSTANCE.dtoToDomain(data);
		var resultados = retrieveAfiliado.execute(afiliadoDomain);
		return AfiliadoDtoMapper.INSTANCE.domainToDtoCollection(resultados);
	}

}

