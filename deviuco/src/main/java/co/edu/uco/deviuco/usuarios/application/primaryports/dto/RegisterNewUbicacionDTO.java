package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class RegisterNewUbicacionDTO {
	private String ubicacionNombre;
	private UUID sedeId;
	private UUID tipoUbicacionId;

	

	public RegisterNewUbicacionDTO(final String ubicacionNombre, final UUID sedeId,final UUID  tipoUbicacionId) {
		setUbicacionNombre(ubicacionNombre);
		setTipoUbicacionId(tipoUbicacionId);
		setSedeId(sedeId);
	}
	
	public static RegisterNewUbicacionDTO create(final String ubicacionNombre, final UUID sedeId,final UUID tipoUbicacionId) {
		return new RegisterNewUbicacionDTO(ubicacionNombre, sedeId, tipoUbicacionId);
	}

	private void setUbicacionNombre(String ubicacionNombre) {
		this.ubicacionNombre = TextHelper.applyTrim(ubicacionNombre);
	}

	private void setSedeId(UUID sedeId) {
		this.sedeId = UUIDHelper.getDefault(sedeId, UUIDHelper.getDefault());
	}
	
	private void setTipoUbicacionId(UUID tipoUbicacionId) {
		this.tipoUbicacionId = UUIDHelper.getDefault(tipoUbicacionId, UUIDHelper.getDefault());
		
	}	
	public String getUbicacionNombre() {
		return ubicacionNombre;
	}

	public UUID getSedeId() {
		return sedeId;
	}
	
	public UUID getTipoUbicacionId() {
		return tipoUbicacionId;
	}

}
