package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoidentificacion;

import java.util.UUID;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoIdentificacionEntity;

@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacionEntity, UUID>, TipoIdentificacionRepositoryCustom {

}
