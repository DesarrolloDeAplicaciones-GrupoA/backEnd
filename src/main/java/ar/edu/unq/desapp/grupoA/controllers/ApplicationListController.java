package ar.edu.unq.desapp.grupoA.controllers;


import ar.edu.unq.desapp.grupoA.controllers.responses.ApplicationResponse;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ApplicationRequestRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
        return ApplicationResponse.buildMany(this.getApplicationRequestRepository().findAll());
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
