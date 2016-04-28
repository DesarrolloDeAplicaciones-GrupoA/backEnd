package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginTest  extends AbstractServiceTest{

    @Autowired
    private Login login;
    @Autowired
    private UserModelRepository repository;
    private UserModel user;
    private String userFullName;
    private String userEmail;

    @Before
    public void setUp() {
        this.userFullName = "Foo Bar";
        this.userEmail = "foobar@sample.com";
        this.user = login.signUp(this.userFullName, this.userEmail);
    }

    @Test
    public void loginUserWithoutCar() {

        Assert.assertEquals(user.getFullName(), this.userFullName);
        Assert.assertEquals(user.getEmail(), this.userEmail);
    }

    @Test
    public void initialDriverScoreInZero() {
        Assert.assertEquals(this.user.getDriverScores().size(), 0);
        Assert.assertEquals(this.user.getAccompanistScores().size(), 0);
        Assert.assertEquals(this.user.getPoints(), 0);
    }

    @Test
    public void initialDriverWithOutTravel() {
        Assert.assertEquals(this.user.getTravels().size(), 0);
    }

    @Test
    public void initialDriverWithOutExchanges() {
        Assert.assertEquals(this.user.getExchanges().size(), 0);
    }

    @Test
    public void hasOneMoreUserInRepository() {
        Assert.assertEquals(1, this.repository.count());
    }

    @Test
    public void newUserHasAnId() {
        UserModel user = this.repository.findById(this.user.getId());
        Assert.assertNotNull(user);
    }


    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setRepository(UserModelRepository repository) {
        this.repository = repository;
    }

    public UserModelRepository getRepository() {
        return repository;
    }
}
