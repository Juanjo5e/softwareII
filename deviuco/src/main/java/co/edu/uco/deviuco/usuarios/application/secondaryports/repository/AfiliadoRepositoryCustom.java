package co.edu.uco.deviuco.usuarios.application.secondaryports.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;

@Repository
public interface AfiliadoRepositoryCustom  {
List<AfiliadoEntity> findByFilter(AfiliadoEntity filter);
	
	boolean isAfiliadoBeingUsed(UUID afiliadoId);
	boolean existsByNameIgnoreCase(String nombre);

}


