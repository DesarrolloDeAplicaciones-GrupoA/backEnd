package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.requests.TravelCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.responses.TravelCreationResponse;
import ar.edu.unq.desapp.grupoA.controllers.responses.TravelListResponse;
import ar.edu.unq.desapp.grupoA.controllers.responses.TravelResponse;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.TravelAdding;
import ar.edu.unq.desapp.grupoA.services.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.sql.Time;
import java.util.List;

@Path("travels")
@Controller("travelController")
public class TravelsController {
    private UserTokenRepository userTokenRepository;
    private TravelsService travelsService;
    private TravelAdding travelAdding;

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public TravelCreationResponse create(@QueryParam("token") String token, TravelCreationBody travelBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Time from = new Time(travelBody.getRangeHours().getStartMillis());
        Time to = new Time(travelBody.getRangeHours().getEndMillis());
        Travel travel = this.travelAdding.createTravel(user, travelBody.getNameTravel(), travelBody.getFuel(), travelBody.getToll(), travelBody.getRouteFromBody(), from, to, travelBody.getFrequency());
        return TravelCreationResponse.build(travel);
    }

    @GET
    @Path("all")
    @Consumes("application/json")
    @Produces("application/json")
    public List<TravelResponse> create(@QueryParam("token") String token) {
        List<Travel> travels = this.getTravelsService().search("");
        return TravelListResponse.build(travels);
    }

    @GET
    @Path("search")
    @Produces("application/json")
    public List<TravelResponse> search(@QueryParam("text") String text) {
        List<Travel> travels = this.getTravelsService().search(text);
        return TravelListResponse.build(travels);
    }


    @GET
    @Path("{id}")
    @Produces("application/json")
    public TravelCreationResponse create(@PathParam("id") Integer id) {
        return TravelCreationResponse.build(this.getTravelAdding().get(id));
    }


    public TravelAdding getTravelAdding() {
        return travelAdding;
    }

    @Autowired
    public void setTravelAdding(TravelAdding travelAdding) {
        this.travelAdding = travelAdding;
    }

    public UserTokenRepository getUserTokenRepository() {
        return userTokenRepository;
    }

    @Autowired
    public void setUserTokenRepository(UserTokenRepository userTokenRepository) {
        this.userTokenRepository = userTokenRepository;
    }

    public TravelsService getTravelsService() {
        return travelsService;
    }

    @Autowired
    public void setTravelsService(TravelsService travelsService) {
        this.travelsService = travelsService;
    }
}
