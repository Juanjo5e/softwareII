package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoPinFormatoIncorrectoException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoPinFormatoValidoRule;

@Service
public class AfiliadoPinFormatoValidoRuleImpl implements AfiliadoPinFormatoValidoRule {

	 // Ejemplo de patrón de PIN que acepta 4 a 6 dígitos (puedes ajustar según sea necesario)
    private static final Pattern PIN_PATTERN = Pattern.compile("^[0-9]{4}$");
    private final MessageCatalog messageCatalog;

    public AfiliadoPinFormatoValidoRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	@Override
    public void validate(AfiliadoDomain afiliado) {
        String pin = afiliado.getPin();
        if (pin == null || !PIN_PATTERN.matcher(pin).matches()) {
            throw AfiliadoPinFormatoIncorrectoException.create(messageCatalog);
        }
    }
}
