package co.edu.uco.deviuco.usuarios.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.InstitucionEntity;
import co.edu.uco.deviuco.usuarios.domain.institucion.InstitucionDomain;

public interface InstitucionEntityMapper {

	InstitucionEntityMapper INSTANCE = Mappers.getMapper(InstitucionEntityMapper.class);

	InstitucionDomain entityToDomain(InstitucionEntity entity);

	InstitucionEntity domainToEntity(InstitucionDomain domain);

	List<InstitucionEntity> domainToEntityCollection(List<InstitucionDomain> domainCollection);

	List<InstitucionDomain> entityToDomainCollection(List<InstitucionEntity> entityCollection);

}