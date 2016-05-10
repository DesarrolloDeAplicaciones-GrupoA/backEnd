package ar.edu.unq.desapp.grupoA.models;

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
  //  @JoinColumn(name = "USER_ID")
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


    public String getMessageTest() {
        return messageText;
    }

    public boolean isPublic() {
        return isPublic;
    }
}
