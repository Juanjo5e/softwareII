package co.edu.uco.deviuco.usuarios.application.usecase.tipoubicacion.impl;

import java.util.List;

import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.TipoUbicacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoubicacion.TipoUbicacionRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.tipoubicacion.RetrieveTipoUbicacion;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;

import org.springframework.stereotype.Service;
@Service
public class RetrieveTipoUbicacionImpl implements RetrieveTipoUbicacion{
	
	private TipoUbicacionRepository tipoUbicacionRepository;
	
    public RetrieveTipoUbicacionImpl(final TipoUbicacionRepository tipoUbicacionRepository) {
        this.tipoUbicacionRepository = tipoUbicacionRepository;
    }

	@Override
	public List<TipoUbicacionDomain> execute(TipoUbicacionDomain domain) {
		var tipoUbicacionEntity = TipoUbicacionEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = tipoUbicacionRepository.findByfilter(tipoUbicacionEntity);
		return TipoUbicacionEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

	@Override
	public List<TipoUbicacionDomain> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}