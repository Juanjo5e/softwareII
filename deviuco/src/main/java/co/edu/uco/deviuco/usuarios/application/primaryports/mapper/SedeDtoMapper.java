package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveSedeDTO;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;
@Mapper
public interface SedeDtoMapper {
	
	SedeDtoMapper INSTANCE = Mappers.getMapper(SedeDtoMapper.class);

	SedeDomain dtoToDomain(RetrieveSedeDTO dto);

	RetrieveSedeDTO domainToDto(SedeDomain domain);

	List<RetrieveSedeDTO> domainToDtoCollection(List<SedeDomain> domainCollection);

	List<SedeDomain> dtoToDomainCollection(List<RetrieveSedeDTO> entityCollection);

}
