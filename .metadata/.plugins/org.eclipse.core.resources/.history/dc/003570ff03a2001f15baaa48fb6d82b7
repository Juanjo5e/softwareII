package co.edu.uco.deviuco.usuarios.infrastructure.secondaryports;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.uco.deviuco.usuarios.application.secondaryports.repository.MessageRepository;
import co.edu.uco.deviuco.usuarios.domain.Message;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(Message message) {
        try {
            messageRepository.saveMessage(message);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el mensaje", e);
        }
    }

    public Message getMessage(String id) {
        try {
            Message message = messageRepository.getMessage(id);
            if (message == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado");
            }
            return message;
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener el mensaje", e);
        }
    }

    public List<Message> getAllMessages() {
        try {
            return messageRepository.getAllMessages();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener los mensajes", e);
        }
    }

    public void deleteMessage(String id) {
        try {
            messageRepository.deleteMessage(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el mensaje", e);
        }
    }

    public String getMessageContent(String id) {
        try {
            Message message = messageRepository.getMessage(id);
            if (message != null) {
                return message.getContent();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado");
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener el contenido del mensaje", e);
        }
    }
}
