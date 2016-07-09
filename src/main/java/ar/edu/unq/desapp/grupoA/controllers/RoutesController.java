package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.TravelCreationResponse;
import ar.edu.unq.desapp.grupoA.controllers.responses.TravelListResponse;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.List;

@Path("routes")
@Controller("routesController")
public class RoutesController {
    private UserTokenRepository userTokenRepository;
    private TravelRepository travelRepository;
    private TravelsService getTravelsService;
    @GET
    @Path("all")
    @Consumes("application/json")
    @Produces("application/json")
    public List<TravelCreationResponse> create(@QueryParam("token") String token) {
        List<Travel> travels = this.getTravelRepository().findAll();
        return TravelListResponse.build(travels);
    }
    @GET
    @Path("search")
    @Produces("application/json")
    public List<TravelCreationResponse> search(@QueryParam("text") String text) {
        List<Travel> travels = this.getGetTravelsService().search(text);
        return TravelListResponse.build(travels);
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

    public TravelsService getGetTravelsService() {
        return getTravelsService;
    }

    @Autowired
    public void setGetTravelsService(TravelsService getTravelsService) {
        this.getTravelsService = getTravelsService;
    }
}
