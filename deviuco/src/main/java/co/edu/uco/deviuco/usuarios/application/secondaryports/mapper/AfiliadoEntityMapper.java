package co.edu.uco.deviuco.usuarios.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;

@Mapper
public interface AfiliadoEntityMapper {
	
	AfiliadoEntityMapper INSTANCE = Mappers.getMapper(AfiliadoEntityMapper.class);

	AfiliadoDomain entityToDomain(AfiliadoEntity entity);

	AfiliadoEntity domainToEntity(AfiliadoDomain domain);

	List<AfiliadoEntity> domainToEntityCollection(List<AfiliadoDomain> domainCollection);

	List<AfiliadoDomain> entityToDomainCollection(List<AfiliadoEntity> entityCollection);

}