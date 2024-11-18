package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UpdateAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.UpdateAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.AfiliadoResponse;
import co.edu.uco.deviuco.usuarios.infrastructure.secondaryports.MessageService;

@RestController
@RequestMapping("/general/api/v1/usuarios")
@CrossOrigin(origins = "https://localhost:5173")
public class UpdateAfiliadoController {

    private final UpdateAfiliadoInteractor updateAfiliadoInteractor;
    private final MessageService messageService;

    public UpdateAfiliadoController(final UpdateAfiliadoInteractor updateAfiliadoInteractor,
                                    final MessageService messageService) {
        this.updateAfiliadoInteractor = updateAfiliadoInteractor;
        this.messageService = messageService;
    }

    @PutMapping
    public ResponseEntity<AfiliadoResponse> actualizar(@RequestBody UpdateAfiliadoDTO dto) {
        var httpStatusCode = HttpStatus.OK;
        var afiliadoResponse = new AfiliadoResponse();

        try {
            updateAfiliadoInteractor.execute(dto);
            afiliadoResponse.getMensajes().add(messageService.getMessageContent("cuenta_actualizada"));

        } catch (final DeviUcoException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            afiliadoResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            afiliadoResponse.getMensajes().add("Ocurrió un error inesperado al actualizar la cuenta.");
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(afiliadoResponse, httpStatusCode);
    }
}