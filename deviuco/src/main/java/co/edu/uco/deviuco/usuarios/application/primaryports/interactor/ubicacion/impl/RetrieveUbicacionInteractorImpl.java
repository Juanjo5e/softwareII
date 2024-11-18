package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.RetrieveUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.UbicacionDtoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RetrieveUbicacion;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class RetrieveUbicacionInteractorImpl implements RetrieveUbicacionInteractor {
	
	public RetrieveUbicacion retrieveUbicacion;
	
	public RetrieveUbicacionInteractorImpl (RetrieveUbicacion retrieveUbicacion) {
		this.retrieveUbicacion = retrieveUbicacion;
	}

	@Override
	public List<UbicacionDTO> execute(UbicacionDTO data) {
		var ubicacionDomain = UbicacionDtoMapper.INSTANCE.dtoToDomain(data);
		var resultados = retrieveUbicacion.execute(ubicacionDomain);
		return UbicacionDtoMapper.INSTANCE.domainToDtoCollection(resultados);
	}

}
