package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.UUID;


import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;

public interface RegisterNewAfiliadoMapper {
	RegisterNewAfiliadoMapper INSTANCE = Mappers.getMapper(RegisterNewAfiliadoMapper.class);

	@Mapping(source = "cityName", target = "name")
	@Mapping(source = "stateId", target = "state", qualifiedByName = "mapToStateDomain")
	AfiliadoDomain toDomain(RegisterNewAfiliadoDTO dto);

	@Named("mapToStateDomain")
	default TipoIdentificacionDomain mapToTipoIdentificacionDomain(UUID tipoIdentificacionId) {
		return new TipoIdentificacionDomain(tipoIdentificacionId, null);
	}

}