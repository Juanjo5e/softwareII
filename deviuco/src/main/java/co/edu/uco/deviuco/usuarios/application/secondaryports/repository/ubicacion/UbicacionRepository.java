package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.UbicacionEntity;

public interface UbicacionRepository extends JpaRepository<UbicacionEntity, UUID>, UbicacionRepositoryCustom{

}
