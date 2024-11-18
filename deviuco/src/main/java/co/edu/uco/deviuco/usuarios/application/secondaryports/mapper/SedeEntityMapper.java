package co.edu.uco.deviuco.usuarios.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.SedeEntity;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;



@Mapper
public interface SedeEntityMapper {
	
	SedeEntityMapper INSTANCE = Mappers.getMapper(SedeEntityMapper.class);
	
	SedeDomain entityToDomain(SedeEntity entity);
	SedeEntity domainToEntity(SedeDomain domain);
	
	List<SedeEntity> domainToEntityCollection(List<SedeDomain> domainCollection);

	List<SedeDomain> entityToDomainCollection(List<SedeEntity> entityCollection);
	
}
