package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.sede.impl;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveSedeDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.sede.RetrieveSedeInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.SedeDtoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.sede.RetrieveSede;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;

@Service
@Transactional
public class RetrieveSedeInteractorImpl implements RetrieveSedeInteractor {

    private final RetrieveSede retrieveSede;

    public RetrieveSedeInteractorImpl(RetrieveSede retrieveSede) {
        this.retrieveSede = retrieveSede;
    }

    @Override
    public List<RetrieveSedeDTO> execute(RetrieveSedeDTO data) {
        List<SedeDomain> resultados;
        
        if (data == null || (data.getId() == null && data.getNombre() == null)) {
            resultados = retrieveSede.findAll();
        } else {
            var sedeDomain = SedeDtoMapper.INSTANCE.dtoToDomain(data);
            resultados = retrieveSede.execute(sedeDomain);
        }
        
        if (resultados.isEmpty()) {
            throw new IllegalStateException("No se encontraron resultados en la base de datos");
        }
        
        return SedeDtoMapper.INSTANCE.domainToDtoCollection(resultados);
    }
}
