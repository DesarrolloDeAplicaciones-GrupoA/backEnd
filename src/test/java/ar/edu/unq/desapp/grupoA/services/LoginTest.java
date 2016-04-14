package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by DamianRafael on 29/3/2016.
 */
public class LoginTest {
    private Login login;
    private UserModel user;

    @Before
    public void setUp() {
        this.login = new Login();
        this.user = login.signUp("Foo Bar", "foobar@sample.com");
    }

    @Test
    public void loginUserWithoutCar() {

        Assert.assertEquals(user.getFullName(), "Foo Bar");
        Assert.assertEquals(user.getEmail(), "foobar@sample.com");
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

}
