package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.PointResponse;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.PointRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by damian on 08/07/16.
 */
@Path("points")
@Controller("pointController")
public class PointController {

    private UserTokenRepository userTokenRepository;
    private PointRepository pointRepository;

    @GET
    @Path("all")
    @Consumes("application/json")
    @Produces("application/json")
    public List<PointResponse> all(@QueryParam("token") String token) {
        List<PointResponse> pointListInSistem = (getPointRepository().findAll().stream()
                .map(point -> new PointResponse(point.getId(), point.getLatitude(), point.getLongitude())))
                .collect(Collectors.toCollection(ArrayList::new));

        return pointListInSistem;
    }

    public PointRepository getPointRepository() {
        return pointRepository;
    }

    @Autowired
    public void setPointRepository(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public UserTokenRepository getUserTokenRepository() {
        return userTokenRepository;
    }

    @Autowired
    public void setUserTokenRepository(UserTokenRepository userTokenRepository) {
        this.userTokenRepository = userTokenRepository;
    }
}


