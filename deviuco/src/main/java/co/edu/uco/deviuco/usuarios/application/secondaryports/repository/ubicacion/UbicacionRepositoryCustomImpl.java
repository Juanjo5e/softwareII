package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.ubicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.UbicacionEntity;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RepositoryDeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class UbicacionRepositoryCustomImpl implements UbicacionRepositoryCustom {

	private EntityManager entityManager;

	public UbicacionRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<UbicacionEntity> findByFilter(final UbicacionEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(UbicacionEntity.class);
			var result = query.from(UbicacionEntity.class);

			var predicates = new ArrayList<>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}

				if (!TextHelper.isEmpty(filter.getNombre())) {
					predicates.add(criteriaBuilder.equal(result.get("nombre"), filter.getNombre()));
				}

				if (!UUIDHelper.isDefault(filter.getSede().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("sede"), filter.getSede()));
				}
				
				if (!UUIDHelper.isDefault(filter.getTipoUbicacion().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("tipoUbicacion"), filter.getTipoUbicacion()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			throw RepositoryDeviUcoException.create(null, null, exception);
		}
	}

	@Override
	public boolean isUbicacionBeingUsed(UUID ubicacionId) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Long.class);
			var root = query.from(UbicacionEntity.class);

			query.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("id"), ubicacionId));

			Long count = entityManager.createQuery(query).getSingleResult();

			return count > 0;

		} catch (final Exception exception) {
			throw RepositoryDeviUcoException.create("Error al verificar si la ubicacion está siendo utilizada", null,
					exception);
		}
	}
	@Override
	public boolean existsByNameIgnoreCase(String name) {
	    try {
	        var criteriaBuilder = entityManager.getCriteriaBuilder();
	        var query = criteriaBuilder.createQuery(Long.class);
	        var root = query.from(UbicacionEntity.class);

	        // Realizamos una comparación sin tener en cuenta mayúsculas y minúsculas
	        query.select(criteriaBuilder.count(root))
	             .where(criteriaBuilder.equal(criteriaBuilder.lower(root.get("nombre")), name.toLowerCase()));

	        Long count = entityManager.createQuery(query).getSingleResult();

	        return count > 0;

	    } catch (final Exception exception) {
	        throw RepositoryDeviUcoException.create("Error al verificar si la ubicacion con el nombre ya existe", null, exception);
	    }
	}
}