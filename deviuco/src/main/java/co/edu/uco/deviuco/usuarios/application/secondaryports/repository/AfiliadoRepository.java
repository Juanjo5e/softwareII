package co.edu.uco.deviuco.usuarios.application.secondaryports.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;

@Repository
public interface AfiliadoRepository extends JpaRepository<AfiliadoEntity, UUID>, AfiliadoRepositoryCustom {

}
