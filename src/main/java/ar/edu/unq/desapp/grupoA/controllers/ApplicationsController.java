package ar.edu.unq.desapp.grupoA.controllers;


import ar.edu.unq.desapp.grupoA.controllers.requests.ApplicationRequestCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.responses.ApplicationRequestCreationResponse;
import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.sql.Date;

@Path("travels/{travelId}/applications/")
@Controller("applicationController")
public class ApplicationsController {

    private ApplicationRequestService applicationRequestService;
    private UserTokenRepository userTokenRepository;
    private TravelRepository travelRepository;

    @POST
    @Path("new")
    @Consumes("application/json")
    @Produces("application/json")
    public ApplicationRequestCreationResponse create(@QueryParam("token") String token, @PathParam("travelId") Integer travelId, ApplicationRequestCreationBody creationBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Travel travel = this.getTravelRepository().findById(travelId);
        Route route = travel.getRoute();
        Date upDate = creationBody.buildUpDate();
        ApplicationRequest application = this.getApplicationRequestService().createApplicationRequest(user, travel, upDate, route.getStart(), route.getEnd() );

        return ApplicationRequestCreationResponse.build(application);
    }

    public ApplicationRequestService getApplicationRequestService() {
        return applicationRequestService;
    }

    @Autowired
    public void setApplicationRequestService(ApplicationRequestService applicationRequestService) {
        this.applicationRequestService = applicationRequestService;
    }

    public UserTokenRepository getUserTokenRepository() {
        return userTokenRepository;
    }

    @Autowired
    public void setUserTokenRepository(UserTokenRepository userTokenRepository) {
        this.userTokenRepository = userTokenRepository;
    }

    public TravelRepository getTravelRepository() {
        return travelRepository;
    }

    @Autowired
    public void setTravelRepository(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
}
