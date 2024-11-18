package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.UbicacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion.UbicacionRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.ubicacion.RetrieveUbicacion;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;
@Service
public class RetrieveUbicacionImpl implements RetrieveUbicacion{
	
	private UbicacionRepository ubicacionRepository;
	
	public RetrieveUbicacionImpl(final UbicacionRepository ubicacionRepository ) {
		this.ubicacionRepository = ubicacionRepository;
	}

	@Override
	public List<UbicacionDomain> execute(UbicacionDomain domain) {
		var ubicacionEntity = UbicacionEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = ubicacionRepository.findByFilter(ubicacionEntity);
		return UbicacionEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

}
