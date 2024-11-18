package co.edu.uco.deviuco.usuarios.application.secondaryports.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.UbicacionEntity;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;

@Mapper
public interface UbicacionEntityMapper {
	
	UbicacionEntityMapper INSTANCE = Mappers.getMapper(UbicacionEntityMapper.class);

	UbicacionDomain entityToDomain(UbicacionEntity entity);

	UbicacionEntity domainToEntity(UbicacionDomain domain);

	List<UbicacionEntity> domainToEntityCollection(List<UbicacionDomain> domainCollection);

	List<UbicacionDomain> entityToDomainCollection(List<UbicacionEntity> entityCollection);

}