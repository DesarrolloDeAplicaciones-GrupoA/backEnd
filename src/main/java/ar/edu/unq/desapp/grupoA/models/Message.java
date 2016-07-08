package ar.edu.unq.desapp.grupoA.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;
import org.joda.time.contrib.hibernate.PersistentDateTime;


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
    @JoinColumn(name = "SENDER_ID")
    private UserModel sender;

    @Column(name = "message_text")
    private String messageText;
    @Column(name = "is_public")
    private boolean isPublic;


    @Column
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime dateTime;
    @Column(name = "subject")
    private String subject;

    public Message(UserModel receiver, UserModel sender, String subject, String messageText, boolean isPublic) {
        this.receiver = receiver;
        this.sender = sender;
        this.messageText = messageText;
        this.isPublic = isPublic;
        this.subject = subject;
        this.dateTime = DateTime.now();
    }

    public Message() {
    }

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

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
