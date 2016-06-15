package ar.edu.unq.desapp.grupoA.controllers.requests;


import ar.edu.unq.desapp.grupoA.models.UserModel;

public class MessageCreationBody {
    private UserModel receiver;
    private UserModel sender;
    private String messageText;
    private boolean isPublic;


    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public UserModel getReceiver() {
        return receiver;
    }

    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


}
