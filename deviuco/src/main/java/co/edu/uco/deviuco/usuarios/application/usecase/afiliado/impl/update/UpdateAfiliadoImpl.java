package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl.update;

import org.springframework.stereotype.Service;


import co.edu.uco.deviuco.usuarios.application.secondaryports.emailsender.NotificationInteractor;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliado;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliadoRulesValidator;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
import co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions.AfiliadoIdDoesExistsException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.DeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

@Service
public class UpdateAfiliadoImpl implements UpdateAfiliado {

    private final AfiliadoRepository afiliadoRepository;
    private final UpdateAfiliadoRulesValidator updateAfiliadoRulesValidator;
    private final NotificationInteractor notificationInteractor;

    public UpdateAfiliadoImpl(
            final AfiliadoRepository afiliadoRepository,
            final UpdateAfiliadoRulesValidator updateAfiliadoRulesValidator,
            final NotificationInteractor notificationInteractor) {
        this.afiliadoRepository = afiliadoRepository;
        this.updateAfiliadoRulesValidator = updateAfiliadoRulesValidator;
        this.notificationInteractor = notificationInteractor;
    }

    @Override
    public void execute(AfiliadoDomain domain) {
        // Validar los datos del afiliado
        updateAfiliadoRulesValidator.validate(domain);

        // Validar que el afiliado existe usando el tipo de identificación y el número de identificación
        if (!afiliadoRepository.existsByTipoIdentificacionIdAndNumeroIdAfiliado(domain.getTipoIdentificacion().getId(), domain.getNumeroIdAfiliado())) {
            throw new DeviUcoException("El afiliado no se encuentra en el sistema.", "Failed t o locate affiliate in system by provided identification.",AfiliadoIdDoesExistsException.create("pruebas"),
                Layer.SERVICE
            );
        }

        // Buscar el afiliado por tipo de identificación y número de identificación
        AfiliadoEntity afiliadoEntity = afiliadoRepository.findByTipoIdentificacionIdAndNumeroIdAfiliado(domain.getTipoIdentificacion().getId(), domain.getNumeroIdAfiliado())
                .orElseThrow(() -> new DeviUcoException(
                    "El afiliado no se encuentra al intentar actualizar.",
                    "Affiliate with given identification not found in database when updating.",
                    AfiliadoIdDoesExistsException.create("Prueba"),
                    Layer.SERVICE
                ));

        // Actualizar los campos permitidos
        afiliadoEntity.setCorreo(domain.getCorreo());
        afiliadoEntity.setTelefono(domain.getTelefono());
        afiliadoEntity.setPin(domain.getPin());

        // Guardar los cambios en la base de datos
        afiliadoRepository.save(afiliadoEntity);

        // Notificar sobre la actualización
        notificationInteractor.notifyAfiliadoUpdate(domain.getCorreo(), domain.getNombre());
    }
}
