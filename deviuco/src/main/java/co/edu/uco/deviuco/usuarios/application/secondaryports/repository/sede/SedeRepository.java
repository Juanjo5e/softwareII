package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.sede;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.SedeEntity;

@Repository
public interface SedeRepository extends JpaRepository<SedeEntity, UUID>, SedeRepositoryCustom {

}
