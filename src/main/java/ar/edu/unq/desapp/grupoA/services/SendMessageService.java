package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.MessageRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

        Message messageObjet = new Message(sender, receiver,subject, messageText, isPublic);
        sender.addMessageSend(messageObjet);
        receiver.addMessageReceived(messageObjet);
        messageRepository.save(messageObjet);
        return messageObjet;
    }
    @Transactional
    public void createDefaultsMessage() {
        Message defaultMessage = new Message(userFactory.getUserAdmin(),userFactory.getUser(),"Welcome","Welcome to SubiQueTeLlevo",true);
        this.messageRepository.save(defaultMessage);
    }
    public Set<Message> findMessagesReceived(UserModel receiver){
        return this.messageRepository.findMessagesReceived(receiver);
    }
    public Set<Message> findMessagesSended(UserModel sender){
        return this.messageRepository.findMessagesSended(sender);
    }
    public List<Message> findPublicMessage(){
        return this.messageRepository.findPublicMessage();
    }
    public Message getProductByID(Integer id){
            return this.messageRepository.findById(id);}

}
