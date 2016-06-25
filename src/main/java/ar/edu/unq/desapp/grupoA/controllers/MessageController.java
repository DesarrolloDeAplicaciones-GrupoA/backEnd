package ar.edu.unq.desapp.grupoA.controllers;


import ar.edu.unq.desapp.grupoA.controllers.requests.MessageCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.responses.MessageCreationResponse;
import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


@Path("message")
@Controller("messageController")
public class MessageController {

    private UserTokenRepository userTokenRepository;
    private SendMessageService sendMessageService;

    @GET
    @Path("allpublic")
    @Produces("application/json")
    public List<MessageCreationResponse> getAll() {
        List<MessageCreationResponse> result = new ArrayList<MessageCreationResponse>();
        for (Message msj : this.getSendMessageService().findPublicMessage()) {
            result.add(MessageCreationResponse.build(msj));
        }
        return result;
    }

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public MessageCreationResponse create(@QueryParam("token") String token, MessageCreationBody messageBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Message message = this.sendMessageService.sendMessage(messageBody.getSender(), messageBody.getReceiver(), messageBody.getMessageText(), messageBody.isPublic());
        return MessageCreationResponse.build(message);
    }

    @GET
    @Path("{id}")
    //@Consumes("application/json")
    @Produces("application/json")
    public MessageCreationResponse findProductsByID(@PathParam("id") Integer id) {
        Message messageFound = this.getSendMessageService().getProductByID(id);
        return MessageCreationResponse.build(messageFound);
    }


    @PostConstruct
    public void loadData() {
        this.getSendMessageService().createDefaultsMessage();
    }

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }

    @Autowired
    public void setUserTokenRepository(UserTokenRepository userTokenRepository) {
        this.userTokenRepository = userTokenRepository;
    }

    public UserTokenRepository getUserTokenRepository() {
        return userTokenRepository;
    }

}
