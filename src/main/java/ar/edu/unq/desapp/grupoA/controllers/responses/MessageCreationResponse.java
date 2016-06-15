package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;

public class MessageCreationResponse {

    private String receiver;
    private String sender;
    private String messageText;
    private boolean isPublic;
    private Integer id;

    public MessageCreationResponse(UserModel receiver, UserModel sender, String messageText, boolean isPublic, Integer id) {
        this.receiver = receiver.getFullName();
        this.sender = sender.getFullName();
        this.messageText = messageText;
        this.isPublic = isPublic;
        this.id = id;
    }

    public static MessageCreationResponse build(Message message) {
        return new MessageCreationResponse(message.getReceiver(), message.getSender(), message.getMessageTest(), message.isPublic(), message.getId());
    }

}
