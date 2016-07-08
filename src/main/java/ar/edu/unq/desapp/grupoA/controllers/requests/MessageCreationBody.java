package ar.edu.unq.desapp.grupoA.controllers.requests;


public class MessageCreationBody {
    private Integer receiver;
    private String messageText;
    private String subject;
    private boolean isPublic;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }
    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


}
