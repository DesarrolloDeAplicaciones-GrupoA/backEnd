package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.services.Login;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


//import java.util.logging.Logger;

@Path("userModels")
@Controller("loginController")
public class LoginController {

    private Login login;
    private UserModelFactory userFactory;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<UserModel> getAll() {
        log.info("Call Service and get all user");
        return this.getLogin().findAll();
    }

    public Login getLogin() {
        return login;
    }

    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public void setLogin(Login login) {
        this.login = login;
        log.info("Set Login Controller");
    }


    @PostConstruct
    public void loadData() {
        this.getUserFactory().getUser();
        this.getUserFactory().getUser();
        log.info("Finish create test users");
        log.warn("TESTING WARNING");

    }

    public UserModelFactory getUserFactory() {
        return userFactory;
    }

    @Autowired
    public void setUserFactory(UserModelFactory userFactory) {
        this.userFactory = userFactory;
    }


}
