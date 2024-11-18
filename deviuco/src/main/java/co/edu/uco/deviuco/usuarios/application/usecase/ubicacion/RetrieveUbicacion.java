package co.edu.uco.deviuco.usuarios.application.usecase.ubicacion;

import java.util.List;

import co.edu.uco.deviuco.usuarios.application.usecase.UseCaseWhitReturn;
import co.edu.uco.deviuco.usuarios.domain.ubicacion.UbicacionDomain;

public interface RetrieveUbicacion extends UseCaseWhitReturn<UbicacionDomain, List<UbicacionDomain>> {

}
