package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.oauth.GoogleOauthCredential;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.utils.google.fakes.Faker;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.jcabi.aspects.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Loggable
@Service("loginService")
public class Login {

    private UserModelRepository userModelRepository;
    private UserTokenService userTokenService;
    private Faker faker;

    @Loggable
    @Transactional
    public UserModel signUp(String fullName, String email) {
        UserModel user = new UserModel(fullName, email);
        this.userModelRepository.save(user);
        this.getUserTokenService().create(user);
        this.getFaker().afterSignUp(user);
        return user;
    }

    @Loggable
    @Transactional
    public UserModel signUpWithCredentials(Userinfoplus userinfoplus, GoogleOauthCredential googleOauthCredential) {
        UserModel newUser = this.signUp(userinfoplus.getName(), userinfoplus.getEmail());
        newUser.setGoogleOauthCredential(googleOauthCredential);
        newUser.setPicture(userinfoplus.getPicture());
        this.getRepository().update(newUser);
        return newUser;
    }

    @Transactional
    public List<UserModel> findAll() {
        return this.getRepository().findAll();
    }

    //@Loggable
    @Autowired
    public void setRepository(UserModelRepository repository) {
        this.userModelRepository = repository;
    }

    public UserModelRepository getRepository() {
        return userModelRepository;
    }

    public UserTokenService getUserTokenService() {
        return userTokenService;
    }

    @Autowired
    public void setUserTokenService(UserTokenService userTokenService) {
        this.userTokenService = userTokenService;
    }

    public UserModel geUserByID(Integer id) {
        return this.userModelRepository.findById(id);
    }

    public Faker getFaker() {
        return faker;
    }

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }
}
