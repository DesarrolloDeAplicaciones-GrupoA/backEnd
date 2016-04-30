package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.springframework.stereotype.Service;

@Service("sendMessageService")
public class SendMessageService {

    public void sendMessage(UserModel sender, UserModel receiver, String messageText, boolean isPublic) {

        Message messageObjet = new Message(sender, receiver, messageText, isPublic);
        sender.addMessageSend(messageObjet);
        receiver.addMessageReceived(messageObjet);
    }
}
