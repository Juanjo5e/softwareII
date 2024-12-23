package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UbicacionDTO;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;

public interface  UbicacionDtoMapper {
	UbicacionDtoMapper INSTANCE = Mappers.getMapper(UbicacionDtoMapper.class);

	UbicacionDomain dtoToDomain(UbicacionDTO dto);

	UbicacionDTO domainToDto(UbicacionDomain domain);

	List<UbicacionDTO> domainToDtoCollection(List<UbicacionDomain> domainCollection);

	List<UbicacionDomain> dtoToDomainCollection(List<UbicacionDTO> entityCollection);

}