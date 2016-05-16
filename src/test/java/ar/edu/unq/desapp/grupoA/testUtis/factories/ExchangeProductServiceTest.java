package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.factories.ProductFactoryAndRepositorie;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ExchangeProductRepository;
import ar.edu.unq.desapp.grupoA.repositories.ProductRepository;
import ar.edu.unq.desapp.grupoA.services.AbstractServiceTest;
import ar.edu.unq.desapp.grupoA.services.ExchangeProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ExchangeProductServiceTest extends AbstractServiceTest{

    private UserModel user;
    private Product product;

    @Autowired
    public ExchangeProductService service;
    @Autowired
    protected UserModelTestFactory userModelTestFactory;
    @Autowired
    protected ExchangeProductRepository exchangeProductRepository;
    @Autowired
    protected ProductRepository productRepository;


    @Before
    public void setUp() {
        this.user = this.userModelTestFactory.getUser();
        this.product = new ProductFactoryAndRepositorie().getFuelVoucher100();
        this.productRepository.save(product);
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

    @Test
    public void hasOneMoreExchange(){
        this.user.setPoints(30000);
        assertEquals(0, this.exchangeProductRepository.count());

        this.service.exchangeProduct(user, product);
        assertEquals(1,this.exchangeProductRepository.count());
    }
}
