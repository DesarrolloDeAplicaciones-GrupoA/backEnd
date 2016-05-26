package ar.edu.unq.desapp.grupoA.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserTokenTest {

    private UserToken userToken;

    @Before
    public void setUp() {
        this.userToken = new UserToken();
    }


    @Test
    public void hasNoTokenWhenBuilt() {
        assertNull(this.userToken.getToken());
    }

    @Test
    public void hasTokenAfterCallMethod() {
        this.userToken.generateToken();
        assertNotNull(this.userToken.getToken());
    }
}
