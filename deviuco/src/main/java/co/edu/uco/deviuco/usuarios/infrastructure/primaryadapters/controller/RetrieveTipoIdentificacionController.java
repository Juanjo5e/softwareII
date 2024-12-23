package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetriveTipoIdentificacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.tipoidentificacion.RetrieveTipoIdentificacionInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.TipoIdentificacionResponse;


@RestController
@RequestMapping("/general/api/v1/tipoIdentificacion")
@CrossOrigin(origins = "https://localhost:8080")
public class RetrieveTipoIdentificacionController {
	
	private RetrieveTipoIdentificacionInteractor retrieveTipoIdentificacionInteractor;

	
	public RetrieveTipoIdentificacionController(RetrieveTipoIdentificacionInteractor retrieveTipoIdentificacionInteractor) {
		this.retrieveTipoIdentificacionInteractor = retrieveTipoIdentificacionInteractor;
		
	}
	
	@GetMapping
	public ResponseEntity<TipoIdentificacionResponse> consultar() {
	    var httpStatusCode = HttpStatus.ACCEPTED;
	    var tipoIdentificacionResponse = new TipoIdentificacionResponse();
	    
	    try {
	        var tipoIdentificacionDto = RetriveTipoIdentificacionDTO.create();
	        
	        System.out.println("Ejecutando consulta de tipos de identificación");
	        System.out.println("DTO enviado: " + tipoIdentificacionDto);
	        
	        var resultados = retrieveTipoIdentificacionInteractor.execute(tipoIdentificacionDto);
	        
	        System.out.println("Resultados obtenidos: " + resultados);
	        
	        tipoIdentificacionResponse.setDatos(resultados);
	        tipoIdentificacionResponse.getMensajes().add("Consulta realizada exitosamente");
	    } catch (final DeviUcoException exception) {
	        httpStatusCode = HttpStatus.BAD_REQUEST;
	        tipoIdentificacionResponse.getMensajes().add("Error en la consulta de tipos de identificación");
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        tipoIdentificacionResponse.getMensajes().add("Error interno en la consulta");
	        exception.printStackTrace();
	    }
	    
	    return new ResponseEntity<>(tipoIdentificacionResponse, httpStatusCode);
	}

}