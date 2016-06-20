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
        return new MessageCreationResponse(message.getReceiver(), message.getSender(), message.getMessageText(), message.isPublic(), message.getId());
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
