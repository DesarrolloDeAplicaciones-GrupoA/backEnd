package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.MessageRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SendMessageServiceTest extends AbstractServiceTest {
    private UserModel sender;
    private UserModel receiver;
    private String message;
    private String subject;
    private int cantidadInicial;
    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private UserModelTestFactory userModelTestFactory;
    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        this.sender = this.userModelTestFactory.getUser();
        this.receiver = this.userModelTestFactory.getUser();
        this.message = StringUtils.getRandomString();
        this.subject = "Subject";
        this.cantidadInicial = this.messageRepository.count();
        sendMessageService.sendMessage(sender, receiver, subject, this.message, true);
    }

    @Test
    public void testSendAReceiveMessage() {
        assertEquals(this.sender.getMessagesSend().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().iterator().next(), this.sender.getMessagesSend().iterator().next());
    }

    @Test
    public void testMessageContent() {
        assertEquals(this.message, this.sender.getMessagesSend().iterator().next().getMessageText());
        assertTrue(this.sender.getMessagesSend().iterator().next().isPublic());
    }

    @Test
    public void hasOneMoreMessage() {
        assertEquals(this.cantidadInicial + 1, this.messageRepository.count());
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }

    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}
