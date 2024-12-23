package co.edu.uco.deviuco.usuarios.application.primaryports.mapper;


import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewUbicacionDTO;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;



@Mapper(componentModel = "spring")
public interface RegisterNewUbicacionMapper{
	
	
	RegisterNewUbicacionMapper INSTANCE = Mappers.getMapper(RegisterNewUbicacionMapper.class);
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "ubicacionNombre", target = "nombre")
    @Mapping(source = "tipoUbicacionId", target = "tipoUbicacion", qualifiedByName = "mapToTipoUbicacionDomain")
    @Mapping(source = "sedeId", target = "sede", qualifiedByName = "mapToSedeDomain")
    UbicacionDomain toDomain(RegisterNewUbicacionDTO dto);

    
    	
    
	@Named("mapToTipoUbicacionDomain")
    default TipoUbicacionDomain mapToTipoUbicacionDomain(UUID tipoUbicacionId) {
        if (tipoUbicacionId == null) {
            throw new IllegalArgumentException("Tipo Ubicacion ID cannot be null");
        }
        return new TipoUbicacionDomain(tipoUbicacionId, null);
    }

	@Named("mapToSedeDomain")
    default SedeDomain mapToSedeDomain(UUID sedeId) {
        if (sedeId == null) {
            throw new IllegalArgumentException("Sede ID cannot be null");
        }
        return new SedeDomain(sedeId, null, null, null);
    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	