package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.UserResponse;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserTokenRepository;
import ar.edu.unq.desapp.grupoA.services.Login;
import ar.edu.unq.desapp.grupoA.utils.google.fakes.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("userModels")
@Controller("loginController")
public class LoginController {

    private Login login;
    private Faker faker;
    private UserTokenRepository userTokenRepository;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<UserModel> getAll() {
        return this.getLogin().findAll();
    }

    @GET
    @Path("listUsers")
    @Produces("application/json")
    public List<UserResponse> listUserModel() {
        List<UserResponse> result = new ArrayList<UserResponse>();
        for (UserModel user : this.getLogin().findAll()) {
            result.add(UserResponse.build(user));
        }
        return result;
    }

    @GET
    @Path("myUserInfo")
    @Produces("application/json")
    public UserResponse findUserLogin(@QueryParam("token") String token) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        return UserResponse.build(user);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public UserResponse findUserInfo(@PathParam("id") Integer id) {
        UserModel user = this.getLogin().getRepository().findById(id);
        return UserResponse.build(user);
    }


    @GET
    @Path("cantUsers")
    @Produces("aplication/json")
    public int cantUsers() {
        int cantidad = 0;
        cantidad = this.getLogin().getRepository().count();
        return cantidad;
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
        this.getFaker().createData();
    }


    public Faker getFaker() {
        return faker;
    }

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @Autowired
    public void setUserTokenRepository(UserTokenRepository userTokenRepository) {
        this.userTokenRepository = userTokenRepository;
    }

    public UserTokenRepository getUserTokenRepository() {
        return userTokenRepository;
    }


}
