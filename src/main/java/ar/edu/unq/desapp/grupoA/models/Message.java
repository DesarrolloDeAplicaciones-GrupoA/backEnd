package ar.edu.unq.desapp.grupoA.models;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {

    @Id()
    @GeneratedValue()
    @Column(name = "MESSAGE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel receiver;
    @ManyToOne
    private UserModel sender;

    @Column(name = "message_text")
    private String messageText;
    @Column(name = "is_public")
    private boolean isPublic;

    public Message(UserModel receiver, UserModel sender, String messageText, boolean isPublic) {
        this.receiver = receiver;
        this.sender = sender;
        this.messageText = messageText;
        this.isPublic = isPublic;
    }
    public Message(){}

    public boolean isPublic() {
        return isPublic;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
