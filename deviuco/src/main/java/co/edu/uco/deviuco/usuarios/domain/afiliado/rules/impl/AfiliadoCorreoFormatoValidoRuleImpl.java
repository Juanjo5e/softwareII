package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoCorreoFormatoIncorrectoException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoCorreoFormatoValidoRule;

@Service
public class AfiliadoCorreoFormatoValidoRuleImpl implements AfiliadoCorreoFormatoValidoRule {

private final MessageCatalog messageCatalog;

	
    public AfiliadoCorreoFormatoValidoRuleImpl(MessageCatalog messageCatalog) {
		super();
		this.messageCatalog = messageCatalog;
	}

	private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    @Override
    public void validate(AfiliadoDomain afiliado) {
        String correo = afiliado.getCorreo();
        if (correo == null || !EMAIL_PATTERN.matcher(correo).matches()) {
            throw AfiliadoCorreoFormatoIncorrectoException.create(messageCatalog);
        }
    }
}
