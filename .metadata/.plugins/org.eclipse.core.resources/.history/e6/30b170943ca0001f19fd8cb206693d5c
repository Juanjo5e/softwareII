package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetriveTipoIdentificacionDTO;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;

@Mapper

public interface TipoIdentificacionDtoMapper {

	TipoIdentificacionDtoMapper INSTANCE = Mappers.getMapper(TipoIdentificacionDtoMapper.class);

	TipoIdentificacionDomain dtoToDomain(RetriveTipoIdentificacionDTO dto);

	RetriveTipoIdentificacionDTO domainToDto(TipoIdentificacionDomain domain);

	List<RetriveTipoIdentificacionDTO> domainToDtoCollection(List<TipoIdentificacionDomain> domainCollection);

	List<TipoIdentificacionDomain> dtoToDomainCollection(List<RetriveTipoIdentificacionDTO> entityCollection);

}