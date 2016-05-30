package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.services.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("userModels")
@Controller("loginController")
public class LoginController {

    private Login login;
    private UserModelFactory userFactory;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<UserModel> getAll() {
        return this.getLogin().findAll();
    }

    public Login getLogin() {
        return login;
    }

    @Autowired
    public void setLogin(Login login) {
        this.login = login;
    }


    @PostConstruct
    public void loadData() {
        this.getUserFactory().getUser();
        this.getUserFactory().getUser();
    }

    public UserModelFactory getUserFactory() {
        return userFactory;
    }

    @Autowired
    public void setUserFactory(UserModelFactory userFactory) {
        this.userFactory = userFactory;
    }


}
