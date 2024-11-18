package co.edu.uco.deviuco.usuarios.application.primaryports.dto;

import java.util.UUID;


import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;

public class AfiliadoDTO {
	
	private UUID id;
    private String numeroIdAfiliado;
    private String nombre;
    private String correo;
    private String telefono;
    private String pin;
    
    public AfiliadoDTO() {
        super();
        setId(UUIDHelper.getDefault());
        setNumeroIdAfiliado(TextHelper.EMPTY);
        setNombre(TextHelper.EMPTY);
        setCorreo(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
    }   
    
    public AfiliadoDTO(UUID id, String numeroIdAfiliado, String nombre, String correo, String telefono, String pin) {
        setId(id);
        setNumeroIdAfiliado(numeroIdAfiliado);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setPin(pin);
    }
    
    public static AfiliadoDTO create(UUID id, String numeroIdAfiliado, String nombre, String correo, String telefono, String pin ) {
		return new AfiliadoDTO(id, numeroIdAfiliado, nombre,correo, telefono, pin );
    }
    
    public static AfiliadoDTO create () {
		return new AfiliadoDTO();
		
    }

    public final UUID getId() {
        return id;
    }
    
    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }
    
    public final String getNumeroIdAfiliado() {
        return numeroIdAfiliado;
    }
    
    public void setNumeroIdAfiliado(String numeroIdAfiliado) {
        this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
    }
    
    public final String getNombre() {
        return nombre;
    }
    
    public void setNombre( String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
    
    public final String getCorreo() {
        return correo;
    }
    
    public void setCorreo( String correo) {
        this.correo = TextHelper.applyTrim(correo);
    }
    
    public final String getTelefono() {
        return telefono;
    }
    
    public void setTelefono( String telefono) {
        this.telefono = TextHelper.applyTrim(telefono);
    }
    
    public String getPin() {
		return pin;
	}
    
    public void setPin(String pin) {
        this.telefono = TextHelper.applyTrim(pin);
    }
    
}
