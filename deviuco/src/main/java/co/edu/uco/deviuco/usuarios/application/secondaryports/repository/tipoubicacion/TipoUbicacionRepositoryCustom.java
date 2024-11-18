package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoubicacion;


import java.util.List;
import org.springframework.stereotype.Repository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoUbicacionEntity;

@Repository
public interface TipoUbicacionRepositoryCustom {
	List<TipoUbicacionEntity> findByfilter(TipoUbicacionEntity filter);
}	