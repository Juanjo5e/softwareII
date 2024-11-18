package co.edu.uco.deviuco.usuarios.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoUbicacionEntity;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;

@Mapper
public interface TipoUbicacionEntityMapper {

	TipoUbicacionEntityMapper INSTANCE = Mappers.getMapper(TipoUbicacionEntityMapper.class);

	TipoUbicacionDomain entityToDomain(TipoUbicacionEntity entity);

	TipoUbicacionEntity domainToEntity(TipoUbicacionDomain domain);

	List<TipoUbicacionEntity> domainToEntityCollection(List<TipoUbicacionDomain> domainCollection);

	List<TipoUbicacionDomain> entityToDomainCollection(List<TipoUbicacionEntity> entityCollection);

}
