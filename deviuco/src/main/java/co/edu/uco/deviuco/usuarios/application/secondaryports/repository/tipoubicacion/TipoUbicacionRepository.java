package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoubicacion;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoUbicacionEntity;


@Repository
public interface TipoUbicacionRepository extends JpaRepository<TipoUbicacionEntity, UUID>, TipoUbicacionRepositoryCustom {

}