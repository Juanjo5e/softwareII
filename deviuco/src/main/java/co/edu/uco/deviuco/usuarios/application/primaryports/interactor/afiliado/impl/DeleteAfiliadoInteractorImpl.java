package co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.impl;

import org.springframework.stereotype.Service;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.DeleteAfiliadoDTO;
import co.edu.uco.deviuco.usuarios.application.primaryports.interactor.afiliado.DeleteAfiliadoInteractor;
import co.edu.uco.deviuco.usuarios.application.primaryports.mapper.DeleteAfiliadoMapper;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.delete.DeleteAfiliado;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteAfiliadoInteractorImpl implements DeleteAfiliadoInteractor {

    private final DeleteAfiliado deleteAfiliado;

    public DeleteAfiliadoInteractorImpl(final DeleteAfiliado deleteAfiliado) {
        this.deleteAfiliado = deleteAfiliado;
    }

    @Override
    public void execute(final DeleteAfiliadoDTO data) {
        // Convierte el DTO en un objeto de dominio si es necesario
        var afiliadoDomain = DeleteAfiliadoMapper.INSTANCE.toDomain(data);
        
        // Ejecuta la lógica de eliminación en el caso de uso
        deleteAfiliado.execute(afiliadoDomain);
    }
}