package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado;

import java.util.Optional;
import java.util.UUID;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;

public interface AfiliadoRepository extends AfiliadoRepositoryCustom {
    boolean existsById(UUID id);
    void save(AfiliadoEntity afiliadoEntity);
    boolean existsByCorreo(String correo);
    boolean existsByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);
    boolean existsByTelefono(String telefono);
    Optional<AfiliadoEntity> findById(UUID id);
    Optional<AfiliadoEntity> findByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);
    
    // Nuevo método para eliminar afiliado
    void deleteByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);
}