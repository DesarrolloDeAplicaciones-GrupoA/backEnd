package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SendMessageServiceTest {
    private UserModel sender;
    private UserModel receiver;
    private SendMessageService service;

    @Before
    public void setUp() {
        this.sender = new UserModelTestFactory().getUser();
        this.receiver = new UserModelTestFactory().getUser();
        this.service = new SendMessageService();
        service.sendMessage(sender, receiver, "Este un mensaje de prueba", true);
    }

    @Test
    public void testSendAReceiveMessage() {
        assertEquals(this.sender.getMessagesSend().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().size(), 1);
        assertEquals(this.receiver.getMessagesReceived().get(0), this.sender.getMessagesSend().get(0));
    }

    @Test
    public void testMessageContent() {
        assertEquals(this.sender.getMessagesSend().get(0).getMessageTest(), "Este un mensaje de prueba");
        assertTrue(this.sender.getMessagesSend().get(0).isPublic());
    }

}
