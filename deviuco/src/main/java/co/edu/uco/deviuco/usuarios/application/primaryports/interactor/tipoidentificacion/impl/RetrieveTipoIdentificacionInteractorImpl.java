package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoidentificacion.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetriveTipoIdentificacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoidentificacion.RetrieveTipoIdentificacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.TipoIdentificacionDtoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.tipoidentificacion.RetrieveTipoIdentificacion;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RetrieveTipoIdentificacionInteractorImpl implements RetrieveTipoIdentificacionInteractor {

    private final RetrieveTipoIdentificacion retrieveTipoIdentificacion;

    public RetrieveTipoIdentificacionInteractorImpl(RetrieveTipoIdentificacion retrieveTipoIdentificacion) {
        this.retrieveTipoIdentificacion = retrieveTipoIdentificacion;
    }

    @Override
    public List<RetriveTipoIdentificacionDTO> execute(RetriveTipoIdentificacionDTO data) {
        List<TipoIdentificacionDomain> resultados;
        
        if (data == null || (data.getId() == null && data.getNombre() == null)) {
            resultados = retrieveTipoIdentificacion.findAll();
        } else {
            var tipoIdentificacionDomain = TipoIdentificacionDtoMapper.INSTANCE.dtoToDomain(data);
            resultados = retrieveTipoIdentificacion.execute(tipoIdentificacionDomain);
        }
        
        if (resultados.isEmpty()) {
            throw new IllegalStateException("No se encontraron resultados en la base de datos");
        }
        
        return TipoIdentificacionDtoMapper.INSTANCE.domainToDtoCollection(resultados);
    }
}
