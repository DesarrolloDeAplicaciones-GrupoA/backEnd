package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.factories.ProductFactoryAndRepositorie;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.services.ExchangeProductService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExchangeProductServiceTest {

    public UserModel user;
    public Product product;
    public ExchangeProductService service;

    @Before
    public void setUp() {
        this.user = new UserModelTestFactory().getUser();
        this.product = new ProductFactoryAndRepositorie().getFuelVoucher100();
        this.service = new ExchangeProductService();
    }

    @Test
    public void testCorrectExchange() {
        this.user.setPoints(30000);
        this.service.exchangeProduct(user, product);
        assertEquals(this.user.getExchanges().size(), 1);
        assertEquals(this.user.getPoints(), 15000);
    }

    @Test(expected = InsufficientPointsException.class)
    public void insuficientPointsToExchange() {
        try {
            this.service.exchangeProduct(user, product);
        } catch (InsufficientPointsException excep) {
            assertEquals(excep.getMessage(), "No sufficient points.");
            throw excep;
        }
        assertEquals(this.user.getExchanges().size(), 0);
        assertEquals(this.user.getPoints(), 15000);

    }
}
