package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.AfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RegisterNewAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.RegisterNewAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.RetrieveAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.AfiliadoResponse;
import co.edu.uco.deviuco.usuarios.infrastructure.secondaryports.MessageService;

@RestController
@RequestMapping("/general/api/v1/usuarios")
@CrossOrigin(origins = "https://localhost:8080")
public class RegisterNewAfiliadoController {

	private final RegisterNewAfiliadoInteractor registerNewAfiliadoInteractor;
	private final RetrieveAfiliadoInteractor retrieveAfiliadoInteractor;
	public RegisterNewAfiliadoController(final RegisterNewAfiliadoInteractor registerNewAfiliadoInteractor,
			final RetrieveAfiliadoInteractor retrieveAfiliadoInteractor, final MessageService messageService) {
		this.registerNewAfiliadoInteractor = registerNewAfiliadoInteractor;
		this.retrieveAfiliadoInteractor = retrieveAfiliadoInteractor;
	}

	@PostMapping
	public ResponseEntity<AfiliadoResponse> crear(@RequestBody RegisterNewAfiliadoDTO dto) {
		var httpStatusCode = HttpStatus.CREATED;
		var afiliadoResponse = new AfiliadoResponse();

		try {
			registerNewAfiliadoInteractor.execute(dto);
			afiliadoResponse.getMensajes().add("La cuenta ha sido creada exitosamente.");
		} catch (final DeviUcoException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			afiliadoResponse.getMensajes().add("No se pudo crear la cuenta: " + excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			afiliadoResponse.getMensajes().add("Ocurrió un error inesperado al intentar crear la cuenta. Por favor, inténtelo nuevamente más tarde.");
		}

		return new ResponseEntity<>(afiliadoResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<AfiliadoResponse> consultar() {
		var httpStatusCode = HttpStatus.OK;
		var afiliadoResponse = new AfiliadoResponse();

		try {
			var afiliadoDto = AfiliadoDTO.create();
			afiliadoResponse.setDatos(retrieveAfiliadoInteractor.execute(afiliadoDto));
			afiliadoResponse.getMensajes().add("Consulta de afiliado realizada exitosamente.");
		} catch (final DeviUcoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			afiliadoResponse.getMensajes().add("Error en la consulta de afiliado: " + exception.getUserMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			afiliadoResponse.getMensajes().add("Ocurrió un error inesperado al realizar la consulta. Por favor, inténtelo nuevamente más tarde.");
			exception.printStackTrace();
		}

		return new ResponseEntity<>(afiliadoResponse, httpStatusCode);
	}
}
