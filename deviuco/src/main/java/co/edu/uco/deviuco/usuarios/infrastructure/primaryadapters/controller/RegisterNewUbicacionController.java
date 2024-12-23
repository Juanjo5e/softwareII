package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewUbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UbicacionDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.RegisterNewUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.ubicacion.RetrieveUbicacionInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.UbicacionResponse;
import co.edu.uco.deviuco.usuarios.infrastructure.secondaryports.MessageService;

@RestController
@RequestMapping("/general/api/v1/usuarios/ubicacion")
@CrossOrigin(origins = "https://localhost:8080")
public class RegisterNewUbicacionController {

	private final RegisterNewUbicacionInteractor registerNewUbicacionInteractor;
	private final RetrieveUbicacionInteractor retrieveUbicacionInteractor;
	private final MessageService messageService;

	public RegisterNewUbicacionController(final RegisterNewUbicacionInteractor registerNewUbicacionInteractor,
			final RetrieveUbicacionInteractor retrieveUbicacionInteractor, final MessageService messageService) {
		this.registerNewUbicacionInteractor = registerNewUbicacionInteractor;
		this.retrieveUbicacionInteractor = retrieveUbicacionInteractor;
		this.messageService = messageService;
	}

	@PostMapping
	public ResponseEntity<UbicacionResponse> crear(@RequestBody RegisterNewUbicacionDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var ubicacionResponse = new UbicacionResponse();

		try {
			registerNewUbicacionInteractor.execute(dto);
			ubicacionResponse.getMensajes().add("La ubicacion a sido registrada exitosamente.");
		} catch (final DeviUcoException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ubicacionResponse.getMensajes().add("No se pudo registrar la ubicacion: " + excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			ubicacionResponse.getMensajes().add("Ocurrió un error inesperado al intentar registrar la ubicacion. Por favor, inténtelo nuevamente más tarde.");
		}

		return new ResponseEntity<>(ubicacionResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<UbicacionResponse> consultar() {
		var httpStatusCode = HttpStatus.OK;
		var ubicacionResponse = new UbicacionResponse();

		try {
			var ubicacionDto = UbicacionDTO.create();
			ubicacionResponse.setDatos(retrieveUbicacionInteractor.execute(ubicacionDto));
			ubicacionResponse.getMensajes().add("Consulta de la ubicacion realizada exitosamente.");
		} catch (final DeviUcoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ubicacionResponse.getMensajes().add("Error en la consulta de afiliado: " + exception.getUserMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			ubicacionResponse.getMensajes().add("Ocurrió un error inesperado al realizar la consulta. Por favor, inténtelo nuevamente más tarde.");
			exception.printStackTrace();
		}

		return new ResponseEntity<>(ubicacionResponse, httpStatusCode);
	}
}