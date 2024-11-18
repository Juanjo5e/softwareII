package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoubicacion.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveTipoUbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoubicacion.RetrieveTipoUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.TipoUbicacionDtoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.tipoubicacion.RetrieveTipoUbicacion;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;

@Service
@Transactional
public class RetrieveTipoUbicacionInteractorImpl implements RetrieveTipoUbicacionInteractor{

    private final RetrieveTipoUbicacion retrieveTipoUbicaicion;

    public RetrieveTipoUbicacionInteractorImpl(RetrieveTipoUbicacion retrieveTipoUbicacion) {
        this.retrieveTipoUbicaicion = retrieveTipoUbicacion;
    }

    @Override
    public List<RetrieveTipoUbicacionDTO> execute(RetrieveTipoUbicacionDTO data) {
        List<TipoUbicacionDomain> resultados;
        
        if (data == null || (data.getId() == null && data.getNombre() == null)) {
            resultados = retrieveTipoUbicaicion.findAll();
        } else {
            var tipoUbicaicionDomain = TipoUbicacionDtoMapper.INSTANCE.dtoToDomain(data);
            resultados = retrieveTipoUbicaicion.execute(tipoUbicaicionDomain);
        }
        
        if (resultados.isEmpty()) {
            throw new IllegalStateException("No se encontraron resultados en la base de datos");
        }
        
        return TipoUbicacionDtoMapper.INSTANCE.domainToDtoCollection(resultados);
    }
}
