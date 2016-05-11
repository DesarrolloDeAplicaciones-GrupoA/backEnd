package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("userModels")
@Controller("loginController")
public class LoginController {

    @Autowired
    private UserModelRepository userModelRepository;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<UserModel> getAll() {
        return this.getUserModelRepository().findAll();
    }

    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }
}
