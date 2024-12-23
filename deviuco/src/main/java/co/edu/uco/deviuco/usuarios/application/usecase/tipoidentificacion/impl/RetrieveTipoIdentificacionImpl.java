package co.edu.uco.deviuco.usuarios.application.usecase.tipoidentificacion.impl;

import java.util.List;


import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.TipoIdentificacionEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoidentificacion.TipoIdentificacionRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.tipoidentificacion.RetrieveTipoIdentificacion;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;
import org.springframework.stereotype.Service;
@Service
public class RetrieveTipoIdentificacionImpl implements RetrieveTipoIdentificacion{
	
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	
    public RetrieveTipoIdentificacionImpl(final TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

	@Override
	public List<TipoIdentificacionDomain> execute(TipoIdentificacionDomain domain) {
		var tipoIdentificacionEntity = TipoIdentificacionEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = tipoIdentificacionRepository.findByfilter(tipoIdentificacionEntity);
		return TipoIdentificacionEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

	@Override
	public List<TipoIdentificacionDomain> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}