package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveTipoUbicacionDTO;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;
@Mapper
public interface TipoUbicacionDtoMapper {

	TipoUbicacionDtoMapper INSTANCE = Mappers.getMapper(TipoUbicacionDtoMapper.class);

	TipoUbicacionDomain dtoToDomain(RetrieveTipoUbicacionDTO dto);

	RetrieveTipoUbicacionDTO domainToDto(TipoUbicacionDomain domain);

	List<RetrieveTipoUbicacionDTO> domainToDtoCollection(List<TipoUbicacionDomain> domainCollection);

	List<TipoUbicacionDomain> dtoToDomainCollection(List<RetrieveTipoUbicacionDTO> entityCollection);

}
