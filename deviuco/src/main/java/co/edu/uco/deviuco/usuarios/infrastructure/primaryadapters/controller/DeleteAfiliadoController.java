package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.DeleteAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.DeleteAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response.AfiliadoResponse;
import co.edu.uco.deviuco.usuarios.infrastructure.secondaryports.MessageService;

@RestController
@RequestMapping("/general/api/v1/usuarios")
@CrossOrigin(origins = "http://localhost:8080")
public class DeleteAfiliadoController {

    private final DeleteAfiliadoInteractor deleteAfiliadoInteractor;
    private final MessageService messageService;

    public DeleteAfiliadoController(final DeleteAfiliadoInteractor deleteAfiliadoInteractor,
                                    final MessageService messageService) {
        this.deleteAfiliadoInteractor = deleteAfiliadoInteractor;
        this.messageService = messageService;
    }

    @DeleteMapping
    public ResponseEntity<AfiliadoResponse> eliminar(@RequestBody DeleteAfiliadoDTO dto) {
        var httpStatusCode = HttpStatus.OK;
        var afiliadoResponse = new AfiliadoResponse();

        try {
            deleteAfiliadoInteractor.execute(dto);
            afiliadoResponse.getMensajes().add(messageService.getMessageContent("cuenta_eliminada"));

        } catch (final DeviUcoException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            afiliadoResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            afiliadoResponse.getMensajes().add("Ocurrió un error inesperado al eliminar la cuenta.");
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(afiliadoResponse, httpStatusCode);
    }
}