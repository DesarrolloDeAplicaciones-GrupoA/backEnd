package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.hibernate.id.IncrementGenerator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MessageCreationResponse {

    private String receiver;
    private String sender;
    private String messageText;
    private String subject;
    private boolean isPublic;
    private Integer id;
    private Integer idReceiver;
    private Integer idSender;
    private DateTime dateTime;
    private String dt;
    private DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM yyyy, HH:mm");

    public MessageCreationResponse(UserModel receiver, UserModel sender, String messageText, String subject, DateTime date, boolean isPublic, Integer id) {
        this.receiver = receiver.getFullName();
        this.idReceiver = receiver.getId();
        this.sender = sender.getFullName();
        this.idSender = sender.getId();
        this.messageText = messageText;
        this.subject = subject;
        this.isPublic = isPublic;
        this.id = id;
        this.dateTime = date;
        this.dt = fmt.print(date);
    }

    public static MessageCreationResponse build(Message message) {
        return new MessageCreationResponse(message.getReceiver(), message.getSender(), message.getMessageText(), message.getSubject(), message.getDateTime(), message.isPublic(), message.getId());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
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

    public Integer getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Integer idReceiver) {
        this.idReceiver = idReceiver;
    }

    public Integer getIdSender() {
        return idSender;
    }

    public void setIdSender(Integer idSender) {
        this.idSender = idSender;
    }


}
