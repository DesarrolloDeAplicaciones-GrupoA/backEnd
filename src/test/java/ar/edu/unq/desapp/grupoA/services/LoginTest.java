package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class LoginTest extends AbstractServiceTest {


    private UserModel user;
    private String userFullName;
    private String userEmail;
    private int cantInicial;

    @Autowired
    private Login loginService;
    @Autowired
    private UserModelRepository userModelRepository;

    @Before
    public void setUp() {
        //TODO: Remove this code when @PostConstruct was removed from Login service.
        //this.userModelRepository.deleteAll();
        this.cantInicial = this.userModelRepository.count();
        this.userFullName = StringUtils.getName();
        this.userEmail = StringUtils.getEmail();
        this.user = loginService.signUp(this.userFullName, this.userEmail);
    }

    @Test
    public void loginUserWithoutCar() {

        assertEquals(user.getFullName(), this.userFullName);
        assertEquals(user.getEmail(), this.userEmail);
    }

    @Test
    public void initialDriverScoreInZero() {
        assertEquals(this.user.getDriverScores().size(), 0);
        assertEquals(this.user.getAccompanistScores().size(), 0);
        assertEquals(this.user.getPoints(), 0);
    }

    @Test
    public void initialDriverWithOutTravel() {
        assertEquals(this.user.getTravels().size(), 0);
    }

    @Test
    public void initialDriverWithOutExchanges() {
        assertEquals(this.user.getExchanges().size(), 0);
    }

    @Test
    public void hasOneMoreUserInRepository() {
        assertEquals(cantInicial+1, this.userModelRepository.count());
    }

    @Test
    public void newUserHasAnId() {
        UserModel user = this.userModelRepository.findById(this.user.getId());
        Assert.assertNotNull(user);
    }


    public void setLoginService(Login loginService) {
        this.loginService = loginService;
    }

    public Login getLoginService() {
        return loginService;
    }

    public void setRepository(UserModelRepository repository) {
        this.userModelRepository = repository;
    }

    public UserModelRepository getRepository() {
        return userModelRepository;
    }
}
