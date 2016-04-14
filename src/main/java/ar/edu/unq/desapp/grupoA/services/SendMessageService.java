package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;

public class SendMessageService {

    public void sendMessage(UserModel sender, UserModel receiver, String messageText, boolean isPublic) {

        Message messageObjet = new Message(sender, receiver, messageText, isPublic);
        sender.addMessageSend(messageObjet);
        receiver.addMessageReceived(messageObjet);
    }
}
