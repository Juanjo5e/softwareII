package co.edu.uco.deviuco.usuarios.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;

@Repository
public interface AfiliadoJpaRepository extends JpaRepository<AfiliadoEntity, UUID> {
    boolean existsByCorreo(String correo);
    boolean existsByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);
    boolean existsByTelefono(String telefono);
    Optional<AfiliadoEntity> findByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);

    // Nuevo método para eliminar el afiliado por tipoIdentificacionId y numeroIdAfiliado
    void deleteByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado);
}