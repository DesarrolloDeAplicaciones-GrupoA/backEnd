package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sendMessageService")
public class SendMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public void sendMessage(UserModel sender, UserModel receiver, String messageText, boolean isPublic) {

        Message messageObjet = new Message(sender, receiver, messageText, isPublic);
        sender.addMessageSend(messageObjet);
        receiver.addMessageReceived(messageObjet);
        messageRepository.save(messageObjet);
    }
}
