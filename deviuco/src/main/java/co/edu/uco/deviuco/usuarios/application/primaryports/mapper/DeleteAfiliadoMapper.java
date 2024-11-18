
package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.DeleteAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;

@Mapper(componentModel = "spring")
public interface DeleteAfiliadoMapper {

    DeleteAfiliadoMapper INSTANCE = Mappers.getMapper(DeleteAfiliadoMapper.class);

    @Mapping(source = "tipoIdentificacionId", target = "tipoIdentificacion", qualifiedByName = "mapToTipoIdentificacionDomain")
    @Mapping(source = "numeroIdAfiliado", target = "numeroIdAfiliado")
    AfiliadoDomain toDomain(DeleteAfiliadoDTO dto);

    @Named("mapToTipoIdentificacionDomain")
    default TipoIdentificacionDomain mapToTipoIdentificacionDomain(UUID tipoIdentificacionId) {
        if (tipoIdentificacionId == null) {
            throw new IllegalArgumentException("Tipo Identificacion ID cannot be null");
        }
        return new TipoIdentificacionDomain(tipoIdentificacionId, null);
    }
}