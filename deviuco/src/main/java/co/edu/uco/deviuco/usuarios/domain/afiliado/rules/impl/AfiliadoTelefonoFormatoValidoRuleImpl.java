package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoTelefonoFormatoIncorrectoException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoTelefonoFormatoValidoRule;

@Service
public class AfiliadoTelefonoFormatoValidoRuleImpl implements AfiliadoTelefonoFormatoValidoRule {

	  // Ejemplo de patrón de teléfono que acepta 10 dígitos (se puede ajustar según el formato requerido)
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10}$");
    
    private final MessageCatalog messageCatalog;

    public AfiliadoTelefonoFormatoValidoRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
    public void validate(AfiliadoDomain afiliado) {
        String telefono = afiliado.getTelefono();
        if (telefono == null || !PHONE_PATTERN.matcher(telefono).matches()) {
            throw AfiliadoTelefonoFormatoIncorrectoException.create(messageCatalog);
        }
    }
}
