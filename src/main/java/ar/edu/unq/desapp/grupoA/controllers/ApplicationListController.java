package ar.edu.unq.desapp.grupoA.controllers;


import ar.edu.unq.desapp.grupoA.controllers.responses.ApplicationResponse;
import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ApplicationRequestRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.List;

@Path("applications")
@Controller("applicationListController")
public class ApplicationListController {

    private ApplicationRequestService applicationRequestService;
    private UserTokenRepository userTokenRepository;
    private ApplicationRequestRepository applicationRequestRepository;

    @GET
    @Path("mine")
    @Produces("application/json")
    public List<ApplicationResponse> mine(@QueryParam("token") String token) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        return ApplicationResponse.buildMany(this.getApplicationRequestRepository().findForUser(user));
    }


    @GET
    @Path("received")
    @Produces("application/json")
    public List<ApplicationResponse> received(@QueryParam("token") String token) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        return ApplicationResponse.buildMany(this.getApplicationRequestRepository().findForReceiver(user));
    }

    @PUT
    @Path("{id}/approve")
    @Produces("application/json")
    public ApplicationResponse approve(@QueryParam("token") String token, @PathParam("id") Integer applicationId) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        ApplicationRequest applicationRequest = this.getApplicationRequestRepository().findForReceiverAndUser(user, applicationId);
        this.getApplicationRequestService().approveApplicationRequest(applicationRequest);
        return ApplicationResponse.build(applicationRequest);
    }

    @PUT
    @Path("{id}/reject")
    @Produces("application/json")
    public ApplicationResponse reject(@QueryParam("token") String token, @PathParam("id") Integer applicationId) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        ApplicationRequest applicationRequest = this.getApplicationRequestRepository().findForReceiverAndUser(user, applicationId);
        this.getApplicationRequestService().rejectApplicationRequest(applicationRequest);
        return ApplicationResponse.build(applicationRequest);
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

    public ApplicationRequestRepository getApplicationRequestRepository() {
        return applicationRequestRepository;
    }

    @Autowired
    public void setApplicationRequestRepository(ApplicationRequestRepository applicationRequestRepository) {
        this.applicationRequestRepository = applicationRequestRepository;
    }
}
