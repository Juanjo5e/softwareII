package co.edu.uco.deviuco.usuarios.application.secondaryports.redis;

public interface MessageCatalog {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}