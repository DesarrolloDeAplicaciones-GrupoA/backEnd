package ar.edu.unq.desapp.grupoA.models.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class TokenGeneratorTest {

    private TokenGenerator tokenGenerator;

    @Before
    public void setUp() {
        this.tokenGenerator = TokenGenerator.defaultGenerator();
    }

    @Test
    public void returnNewTokenEveryTime() {
        String firstToken = this.tokenGenerator.generate();
        String secondToken = this.tokenGenerator.generate();
        assertNotEquals(firstToken, secondToken);
    }
}
