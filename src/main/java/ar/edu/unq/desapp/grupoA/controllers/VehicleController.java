package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.requests.VehicleCreationBody;
import ar.edu.unq.desapp.grupoA.controllers.responses.VehicleCreationResponse;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.VehicleAdding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

@Path("vehicles")
@Controller("vehicleController")
public class VehicleController {
    private VehicleAdding vehicleAdding;
    private UserTokenRepository userTokenRepository;

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public VehicleCreationResponse create(@QueryParam("token") String token, VehicleCreationBody vehicleCreationBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Vehicle vehicle = this.getVehicleAdding().createVehicle(user, vehicleCreationBody.getBrand(), vehicleCreationBody.getCapacity());
        return VehicleCreationResponse.build(vehicle);
    }


    @GET
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public VehicleCreationResponse create(@QueryParam("token") String token, @PathParam("id") Integer id) {
        return VehicleCreationResponse.build(this.getVehicleAdding().get(id));
    }

    @PostConstruct
    public void loadData() {
        this.getVehicleAdding().createExampleVehicle();
    }

    public VehicleAdding getVehicleAdding() {
        return vehicleAdding;
    }

    @Autowired
    public void setVehicleAdding(VehicleAdding vehicleAdding) {
        this.vehicleAdding = vehicleAdding;
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
