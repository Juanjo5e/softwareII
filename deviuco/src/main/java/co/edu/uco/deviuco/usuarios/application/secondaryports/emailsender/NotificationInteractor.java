package co.edu.uco.deviuco.usuarios.application.secondaryports.emailsender;

public interface NotificationInteractor {
    void notifySuccess(String subject, String message);

	void notifyAfiliadoRegistration(String emailAfiliado, String nombreAfiliado);

	void notifyAfiliadoUpdate(String emailAfiliado, String nombreAfiliado);
}