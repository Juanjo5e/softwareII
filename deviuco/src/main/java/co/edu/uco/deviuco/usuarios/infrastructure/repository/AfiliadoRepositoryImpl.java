package co.edu.uco.deviuco.usuarios.infrastructure.repository;

import org.springframework.stereotype.Repository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.AfiliadoEntity;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepositoryCustom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AfiliadoRepositoryImpl implements AfiliadoRepository {

	private final AfiliadoJpaRepository jpaRepository;
    private final AfiliadoRepositoryCustom customRepository;

    public AfiliadoRepositoryImpl(AfiliadoJpaRepository jpaRepository, AfiliadoRepositoryCustom customRepository) {
        this.jpaRepository = jpaRepository;
        this.customRepository = customRepository;
    }
    
    @Override
    public void deleteByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado) {
        jpaRepository.deleteByTipoIdentificacionIdAndNumeroIdAfiliado(tipoIdentificacionId, numeroIdAfiliado);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void save(AfiliadoEntity afiliadoEntity) {
        jpaRepository.save(afiliadoEntity);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return jpaRepository.existsByCorreo(correo);
    }

    @Override
    public boolean existsByTelefono(String telefono) {
        return jpaRepository.existsByTelefono(telefono);
    }

    @Override
    public boolean existsByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado) {
        return jpaRepository.existsByTipoIdentificacionIdAndNumeroIdAfiliado(tipoIdentificacionId, numeroIdAfiliado);
    }

    @Override
    public List<AfiliadoEntity> findByFilter(AfiliadoEntity filter) {
        return customRepository.findByFilter(filter);
    }

    @Override
    public boolean isAfiliadoBeingUsed(UUID afiliadoId) {
        return customRepository.isAfiliadoBeingUsed(afiliadoId);
    }

    @Override
    public boolean existsByNameIgnoreCase(String nombre) {
        return customRepository.existsByNameIgnoreCase(nombre);
    }

    @Override
    public Optional<AfiliadoEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<AfiliadoEntity> findByTipoIdentificacionIdAndNumeroIdAfiliado(UUID tipoIdentificacionId, String numeroIdAfiliado) {
        return jpaRepository.findByTipoIdentificacionIdAndNumeroIdAfiliado(tipoIdentificacionId, numeroIdAfiliado);
    }
}