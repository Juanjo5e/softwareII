package co.edu.uco.deviuco.usuarios.application.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoIdentificacionEntity;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RepositoryDeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class TipoIdentificacionRepositoryCustomImpl implements TipoIdentificacionRepositoryCustom{
	
	private EntityManager entityManager;

	public TipoIdentificacionRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<TipoIdentificacionEntity> findByfilter(TipoIdentificacionEntity filter) {
	    try {
	        var criteriaBuilder = entityManager.getCriteriaBuilder();
	        var query = criteriaBuilder.createQuery(TipoIdentificacionEntity.class);
	        var result = query.from(TipoIdentificacionEntity.class);

	        var predicates = new ArrayList<Predicate>();

	        if (!ObjectHelper.isNull(filter)) {
	            if (!UUIDHelper.isDefault(filter.getId())) {
	                predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
	            }

	            if (!TextHelper.isEmpty(filter.getNombre())) {
	                predicates.add(criteriaBuilder.equal(result.get("nombre"), filter.getNombre()));
	            }
	        }

	        query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
	        return entityManager.createQuery(query).getResultList();

	    } catch (final Exception exception) {
	        throw RepositoryDeviUcoException.create(null, null, exception);
	    }
	}

}
