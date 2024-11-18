package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveTipoUbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetriveTipoIdentificacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoidentificacion.RetrieveTipoIdentificacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoubicacion.RetrieveTipoUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.TipoIdentificacionResponse;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.TipoUbicacionResponse;

@RestController
@RequestMapping("/general/api/v1/tipoUbicacion")
@CrossOrigin(origins = "https://localhost:8080")
public class RetrieveTipoUbicacionController {
	
	private RetrieveTipoUbicacionInteractor retrieveTipoUbicacionInteractor;

	
	public RetrieveTipoUbicacionController(RetrieveTipoUbicacionInteractor retrieveTipoUbicacionInteractor) {
		this.retrieveTipoUbicacionInteractor = retrieveTipoUbicacionInteractor;
		
	}
	
	@GetMapping
	public ResponseEntity<TipoUbicacionResponse> consultar() {
	    var httpStatusCode = HttpStatus.ACCEPTED;
	    var tipoUbicacionResponse = new TipoUbicacionResponse();
	    
	    try {
	        var tipoUbicacionDto = RetrieveTipoUbicacionDTO.create();
	        
	        System.out.println("Ejecutando consulta de tipos de Ubicacion");
	        System.out.println("DTO enviado: " + tipoUbicacionDto);
	        
	        var resultados = retrieveTipoUbicacionInteractor.execute(tipoUbicacionDto);
	        
	        System.out.println("Resultados obtenidos: " + resultados);
	        
	        tipoUbicacionResponse.setDatos(resultados);
	        tipoUbicacionResponse.getMensajes().add("Consulta realizada exitosamente");
	    } catch (final DeviUcoException exception) {
	        httpStatusCode = HttpStatus.BAD_REQUEST;
	        tipoUbicacionResponse.getMensajes().add("Error en la consulta de tipos de Ubicacion");
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        tipoUbicacionResponse.getMensajes().add("Error interno en la consulta");
	        exception.printStackTrace();
	    }
	    
	    return new ResponseEntity<>(tipoUbicacionResponse, httpStatusCode);
	}

}