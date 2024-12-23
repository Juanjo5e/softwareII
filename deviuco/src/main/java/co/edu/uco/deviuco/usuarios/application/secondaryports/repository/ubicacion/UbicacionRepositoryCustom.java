package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.UbicacionEntity;

@Repository
public interface UbicacionRepositoryCustom {
	
	List<UbicacionEntity> findByFilter(UbicacionEntity filter);

	boolean isUbicacionBeingUsed(UUID ubicacionId);
	boolean existsByNameIgnoreCase(String nombre);
	

}
