package co.edu.uco.deviuco.usuarios.infrastructure.secondaryports.emailsender;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;

import co.edu.uco.deviuco.usuarios.application.secondaryports.emailsender.NotificationInteractor;
import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationInteractorImpl implements NotificationInteractor {

    private static final Logger logger = LoggerFactory.getLogger(NotificationInteractorImpl.class);

    private final SecretClient secretClient;
    private final MessageCatalog messageCatalog;

    public NotificationInteractorImpl(@Value("${azure.keyvault.url}") String keyVaultUrl, MessageCatalog messageCatalog) {
        this.secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
        this.messageCatalog = messageCatalog;
    }

    private String getMailerSendApiKey() {
        return secretClient.getSecret("mailsenderapi1").getValue();
    }

    private String getMailerSendEmail() {
        return secretClient.getSecret("deviucoemail").getValue();
    }

    @Override
    public void notifySuccess(String subject, String message) {
        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken(getMailerSendApiKey());

        Email email = new Email();
        email.setFrom("DeviUco pay", getMailerSendEmail());
        email.addRecipient("Admin", getMailerSendEmail());
        email.setSubject(subject);
        email.setPlain(message);
        email.setHtml("<p>" + message + "</p>");

        try {
            MailerSendResponse response = mailerSend.emails().send(email);
            logger.info("Email sent successfully with ID: {}", response.messageId);
        } catch (MailerSendException e) {
            logger.error(messageCatalog.getMessageOrDefault("MailerSendException"), e);
        }
    }

    @Override
    public void notifyAfiliadoRegistration(String emailAfiliado, String nombreAfiliado) {
        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken(getMailerSendApiKey());

        Email email = new Email();
        email.setFrom("DeviUco pay", getMailerSendEmail());
        email.addRecipient(nombreAfiliado, emailAfiliado);
        email.setSubject("¡Bienvenido a DeviUco pay!");
        
        String mensaje = String.format("""
                Estimado/a %s,
                
                ¡Bienvenido/a a DeviUco pay! Nos complace confirmar que su cuenta ha sido registrada exitosamente.
                
                Detalles de su cuenta:
                - Nombre: %s
                - Email: %s
                
                Ya puede comenzar a utilizar nuestros servicios de pago seguro.
                
                Si tiene alguna pregunta o necesita ayuda, no dude en contactarnos.
                
                Saludos cordiales,
                Equipo DeviUco pay
                """, nombreAfiliado, nombreAfiliado, emailAfiliado);
        
        email.setPlain(mensaje);
        email.setHtml("<p>" + mensaje.replace("\n", "<br>") + "</p>");

        try {
            MailerSendResponse response = mailerSend.emails().send(email);
            logger.info("Email de bienvenida enviado al afiliado {} con ID: {}", emailAfiliado, response.messageId);
        } catch (MailerSendException e) {
            logger.error(messageCatalog.getMessageOrDefault("MailerSendException"), e);
        }
    }

    @Override
    public void notifyAfiliadoUpdate(String emailAfiliado, String nombreAfiliado) {
        // Implementación del método para enviar la notificación de actualización
    }
}