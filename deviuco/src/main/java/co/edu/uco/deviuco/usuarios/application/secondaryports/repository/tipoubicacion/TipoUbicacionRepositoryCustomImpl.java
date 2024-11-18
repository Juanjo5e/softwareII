package co.edu.uco.deviuco.usuarios.application.secondaryports.repository.tipoubicacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviuco.usuarios.application.secondaryports.entity.TipoUbicacionEntity;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RepositoryDeviUcoException;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class TipoUbicacionRepositoryCustomImpl implements TipoUbicacionRepositoryCustom{
	
	private EntityManager entityManager;

	public TipoUbicacionRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<TipoUbicacionEntity> findByfilter(TipoUbicacionEntity filter) {
	    try {
	        var criteriaBuilder = entityManager.getCriteriaBuilder();
	        var query = criteriaBuilder.createQuery(TipoUbicacionEntity.class);
	        var result = query.from(TipoUbicacionEntity.class);

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
