package co.edu.uco.deviuco.usuarios.application.usecase.afiliado.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.deviuco.usuarios.application.secondaryports.mapper.AfiliadoEntityMapper;
import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.afiliado.AfiliadoRepository;
import co.edu.uco.deviuco.usuarios.application.usecase.afiliado.RetrieveAfiliado;
import co.edu.uco.deviuco.usuarios.domain.afiliado.AfiliadoDomain;
@Service
public class RetrieveAfiliadoImpl implements RetrieveAfiliado{
	
	private AfiliadoRepository afiliadoRepository;
	
	public RetrieveAfiliadoImpl(final AfiliadoRepository afiliadoRepository ) {
		this.afiliadoRepository = afiliadoRepository;
	}

	@Override
	public List<AfiliadoDomain> execute(AfiliadoDomain domain) {
		var afiliadoEntity = AfiliadoEntityMapper.INSTANCE.domainToEntity(domain);
		var resultadosEntity = afiliadoRepository.findByFilter(afiliadoEntity);
		return AfiliadoEntityMapper.INSTANCE.entityToDomainCollection(resultadosEntity);
	}

}