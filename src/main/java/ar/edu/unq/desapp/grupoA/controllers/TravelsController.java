package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.requests.TravelCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.requests.VehicleCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.responses.VehicleCreationResponse;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.TravelAdding;
import ar.edu.unq.desapp.grupoA.services.VehicleAdding;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;

@Path("travels")
@Controller("travelController")
public class TravelsController {
    private UserTokenRepository userTokenRepository;
    private TravelAdding travelAdding;

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public TravelCreationResponse create(@QueryParam("token") String  token, TravelCreationBody travelBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Travel travel = this.travelAdding.createTravel(user, travelBody.getNameTravel(), travelBody.getFuel(), travelBody.getToll(), travelBody.getRouteFromString(),travelBody.getRangeHours(), travelBody.getFrequencyFromString());
        return TravelCreationResponse.build(travel);
    }


    @GET
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public TravelCreationResponse create(@QueryParam("token") String token, @PathParam("id") Integer id) {
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

    /*
    1. Servicio para dar de alta un recorrido debe estar
    2. Crear un controller en el package controller similar al de vehicleController que cree el recorrido
     3. En el frontENd, hay que crear:
      a. un controller
      b. una view
      c. un service
      d. vincular el path con los anteriores (ver app.js)
     */
}
