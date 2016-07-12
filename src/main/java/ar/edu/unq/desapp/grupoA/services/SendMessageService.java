package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("sendMessageService")
public class SendMessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserModelFactory userFactory;

    @Transactional
    public Message sendMessage(UserModel sender, UserModel receiver, String subject, String messageText, boolean isPublic) {

        Message messageObjet = new Message(receiver,sender, subject, messageText, isPublic);
        sender.addMessageSend(messageObjet);
        receiver.addMessageReceived(messageObjet);
        messageRepository.save(messageObjet);
        return messageObjet;
    }
    @Transactional
    public void createDefaultsMessage() {
        Message defaultMessage = new Message(userFactory.getUser(),userFactory.getUserAdmin(),"Welcome","Welcome to SubiQueTeLlevo",true);
        this.messageRepository.save(defaultMessage);
    }
    public List<Message> findMessagesReceived(UserModel receiver){
        return this.messageRepository.findAllMyMessagesReceived(receiver);
    }
    public List<Message> findMessagesSended(UserModel sender){
        return this.messageRepository.findAllMyMessagesSended(sender);
    }
    public List<Message> findPublicMessage(){
        return this.messageRepository.findAllPublicMessage();
    }

    public List<Message> findAllPublicSendedAndReceivedForAUser(UserModel userModel){
        return this.messageRepository.findAllPublicSendedAndReceivedForAUser(userModel);
    }

    public Message getMessageByID(Integer id){
            return this.messageRepository.findById(id);}

}
