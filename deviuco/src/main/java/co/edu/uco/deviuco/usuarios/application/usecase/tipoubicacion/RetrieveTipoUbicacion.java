package co.edu.uco.deviuco.usuarios.application.usecase.tipoubicacion;
import java.util.List;


import co.edu.uco.deviuco.usuarios.application.usecase.UseCaseWhitReturn;
import co.edu.uco.deviuco.usuarios.domain.tipoubicacion.TipoUbicacionDomain;


public interface RetrieveTipoUbicacion extends UseCaseWhitReturn<TipoUbicacionDomain, List<TipoUbicacionDomain>>{

	List<TipoUbicacionDomain> findAll();

}
