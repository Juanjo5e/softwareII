package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.delete;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.delete.DeleteAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

@Service
public final class DeleteAfiliadoRulesValidatorImpl implements DeleteAfiliadoRulesValidator {

    private final AfiliadoRepository afiliadoRepository;

    public DeleteAfiliadoRulesValidatorImpl(final AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    @Override
    public void validate(final AfiliadoDomain data) {
        // Validar que el afiliado existe usando el tipo de identificación y el número de identificación
        if (!afiliadoRepository.existsByTipoIdentificacionIdAndNumeroIdAfiliado(
                data.getTipoIdentificacion().getId(), data.getNumeroIdAfiliado())) {
            throw new DeviUcoException(
                "El afiliado que intentas eliminar no existe en el sistema.",
                "The affiliate you are trying to delete does not exist in the system.",
                AfiliadoIdDoesExistsException.create("No se puede eliminar el afiliado"),
                Layer.SERVICE
            );
        }
    }
}
