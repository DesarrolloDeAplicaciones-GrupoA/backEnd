package ar.edu.unq.desapp.grupoA.models;

public class Message {

    private UserModel receiver;
    private UserModel sender;
    private String messageText;
    private boolean isPublic;

    public Message(UserModel receiver, UserModel sender, String messageText, boolean isPublic) {
        this.receiver = receiver;
        this.sender = sender;
        this.messageText = messageText;
        this.isPublic = isPublic;
    }


    public String getMessageTest() {
        return messageText;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
