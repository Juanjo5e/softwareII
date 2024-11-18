package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.sede;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.SedeEntity;

@Repository
public interface SedeRepositoryCustom {
	List<SedeEntity> findByfilter(SedeEntity filter);

}