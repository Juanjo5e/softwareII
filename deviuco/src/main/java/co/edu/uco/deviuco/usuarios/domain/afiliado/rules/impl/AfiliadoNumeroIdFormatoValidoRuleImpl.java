package co.edu.uco.deviuco.usuarios.domain.afiliado.rules.impl;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoNumeroIdFormatoIncorrectoException;
import co.edu.uco.deviuco.usuarios.domain.afiliado.rules.AfiliadoNumeroIdFormatoValidoRule;

@Service
public class AfiliadoNumeroIdFormatoValidoRuleImpl implements AfiliadoNumeroIdFormatoValidoRule {

    // Ejemplo de patrón para un número de identificación: solo dígitos, de 8 a 12 caracteres
    private static final Pattern NUMERO_ID_PATTERN = Pattern.compile("^[0-9]{8,12}$");

    @Override
    public void validate(AfiliadoDomain afiliado) {
        String numeroId = afiliado.getNumeroIdAfiliado();
        if (numeroId == null || !NUMERO_ID_PATTERN.matcher(numeroId).matches()) {
            throw AfiliadoNumeroIdFormatoIncorrectoException.create();
        }
    }
}
