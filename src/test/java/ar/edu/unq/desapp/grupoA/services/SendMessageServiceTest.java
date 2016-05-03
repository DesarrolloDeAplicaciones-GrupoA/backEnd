package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SendMessageServiceTest extends AbstractServiceTest{
    private UserModel sender;
    private UserModel receiver;

    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private UserModelTestFactory userModelTestFactory;

    @Before
    public void setUp() {
        this.sender = this.userModelTestFactory.getUser();
        this.receiver = this.userModelTestFactory.getUser();
        sendMessageService.sendMessage(sender, receiver, "Este un mensaje de prueba", true);
    }

    @Test
    public void testSendAReceiveMessage() {
        assertEquals(this.sender.getMessagesSend().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().get(0), this.sender.getMessagesSend().iterator().next());
    }

    @Test
    public void testMessageContent() {
        assertEquals(this.sender.getMessagesSend().iterator().next().getMessageTest(), "Este un mensaje de prueba");
        assertTrue(this.sender.getMessagesSend().iterator().next().isPublic());
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }

    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}
