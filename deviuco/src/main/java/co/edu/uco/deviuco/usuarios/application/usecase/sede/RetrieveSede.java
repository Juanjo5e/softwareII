package co.edu.uco.deviuco.usuarios.application.usecase.sede;
import java.util.List;


import co.edu.uco.deviuco.usuarios.application.usecase.UseCaseWhitReturn;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;


public interface RetrieveSede extends UseCaseWhitReturn<SedeDomain, List<SedeDomain>>{

	List<SedeDomain> findAll();

}
