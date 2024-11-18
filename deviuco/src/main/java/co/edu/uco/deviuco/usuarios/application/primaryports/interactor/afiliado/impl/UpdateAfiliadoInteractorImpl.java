package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UpdateAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.UpdateAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.UpdateAfiliadoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.update.UpdateAfiliado;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UpdateAfiliadoInteractorImpl implements UpdateAfiliadoInteractor {

    private final UpdateAfiliado updateAfiliado;

    public UpdateAfiliadoInteractorImpl(final UpdateAfiliado updateAfiliado) {
        this.updateAfiliado = updateAfiliado;
    }

    @Override
    public void execute(final UpdateAfiliadoDTO data) {
        // Convierte el DTO en un objeto de dominio
        var afiliadoDomain = UpdateAfiliadoMapper.INSTANCE.toDomain(data);
        
        // Ejecuta la lógica de actualización en el caso de uso
        updateAfiliado.execute(afiliadoDomain);
    }
}