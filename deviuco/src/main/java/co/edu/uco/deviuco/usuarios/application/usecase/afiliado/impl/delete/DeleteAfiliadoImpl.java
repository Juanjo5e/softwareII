package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.delete;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.delete.DeleteAfiliado;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

@Service
public class DeleteAfiliadoImpl implements DeleteAfiliado {

    private final AfiliadoRepository afiliadoRepository;

    public DeleteAfiliadoImpl(final AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    @Override
    public void execute(AfiliadoDomain domain) {
        if (!afiliadoRepository.existsByTipoIdentificacionIdAndNumeroIdAfiliado(
                domain.getTipoIdentificacion().getId(), domain.getNumeroIdAfiliado())) {
            throw new DeviUcoException(
                "El afiliado no se encuentra en el sistema.",
                "Failed to locate affiliate in system by provided identification.",
                AfiliadoIdDoesExistsException.create("No se puede crear el usuario"),
                Layer.SERVICE
            );
        }

        try {
            afiliadoRepository.deleteByTipoIdentificacionIdAndNumeroIdAfiliado(
                    domain.getTipoIdentificacion().getId(), domain.getNumeroIdAfiliado());
        } catch (Exception e) {
            throw new DeviUcoException(
                "Error al intentar eliminar el afiliado.",
                "Failed to delete affiliate with provided identification.",
                e,
                Layer.SERVICE
            );
        }
    }
}
