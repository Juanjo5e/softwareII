package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveSedeDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.sede.RetrieveSedeInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.SedeResponse;

@RestController
@RequestMapping("/general/api/v1/sede")
@CrossOrigin(origins = "http://localhost:8080")
public class RetrieveSedeController {
	
	private RetrieveSedeInteractor retrieveSedeInteractor;

	
	public RetrieveSedeController(RetrieveSedeInteractor retrieveSedeInteractor) {
		this.retrieveSedeInteractor = retrieveSedeInteractor;
		
	}
	
	@GetMapping
	public ResponseEntity<SedeResponse> consultar() {
	    var httpStatusCode = HttpStatus.ACCEPTED;
	    var sedeResponse = new SedeResponse();
	    
	    try {
	        var sedeDto = RetrieveSedeDTO.create();
	        
	        System.out.println("Ejecutando consulta de sedes");
	        System.out.println("DTO enviado: " + sedeDto);
	        
	        var resultados = retrieveSedeInteractor.execute(sedeDto);
	        
	        System.out.println("Resultados obtenidos: " + resultados);
	        
	        sedeResponse.setDatos(resultados);
	        sedeResponse.getMensajes().add("Consulta realizada exitosamente");
	    } catch (final DeviUcoException exception) {
	        httpStatusCode = HttpStatus.BAD_REQUEST;
	        sedeResponse.getMensajes().add("Error en la consulta de sedes");
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        sedeResponse.getMensajes().add("Error interno en la consulta");
	        exception.printStackTrace();
	    }
	    
	    return new ResponseEntity<>(sedeResponse, httpStatusCode);
	}

}