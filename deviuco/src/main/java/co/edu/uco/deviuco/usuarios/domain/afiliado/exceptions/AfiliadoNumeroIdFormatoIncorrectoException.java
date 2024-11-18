package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoNumeroIdFormatoIncorrectoException extends RuleDeviUcoException {

    private static final long serialVersionUID = 1L;

    public AfiliadoNumeroIdFormatoIncorrectoException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final AfiliadoNumeroIdFormatoIncorrectoException create() {
        var userMessage = "El formato del número de identificación del afiliado es incorrecto.";
        return new AfiliadoNumeroIdFormatoIncorrectoException(userMessage);
    }
}
