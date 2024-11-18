package co.edu.uco.deviuco.usuarios.application.usecase.sede.impl;

import java.util.List;



import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.SedeEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.sede.SedeRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.sede.RetrieveSede;
import co.edu.uco.deviuco.usuarios.domain.sede.SedeDomain;

import org.springframework.stereotype.Service;
@Service
public class RetrieveSedeImpl implements RetrieveSede{
	
	private SedeRepository sedeRepository;
	
    public RetrieveSedeImpl(final SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

	@Override
	public List<SedeDomain> execute(SedeDomain domain) {
		var sedeEntity = SedeEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = sedeRepository.findByfilter(sedeEntity);
		return SedeEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

	@Override
	public List<SedeDomain> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}