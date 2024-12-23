package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.TipoIdentificacionDomain;

@Mapper(componentModel = "spring")
public interface RegisterNewAfiliadoMapper {

    RegisterNewAfiliadoMapper INSTANCE = Mappers.getMapper(RegisterNewAfiliadoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "numeroIdAfiliado", target = "numeroIdAfiliado")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "pin", target = "pin")
    @Mapping(source = "tipoIdentificacionId", target = "tipoIdentificacion", qualifiedByName = "mapToTipoIdentificacionDomain")
    AfiliadoDomain toDomain(RegisterNewAfiliadoDTO dto);

    
    	
    
    @Named("mapToTipoIdentificacionDomain")
    default TipoIdentificacionDomain mapToTipoIdentificacionDomain(UUID tipoIdentificacionId) {
        if (tipoIdentificacionId == null) {
            throw new IllegalArgumentException("Tipo Identificacion ID cannot be null");
        }
        return new TipoIdentificacionDomain(tipoIdentificacionId, null);
    }

        
}