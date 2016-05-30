package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.exceptions.StockNullException;
import ar.edu.unq.desapp.grupoA.factories.ProductFactory;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ExchangeProductRepository;
import ar.edu.unq.desapp.grupoA.services.AbstractServiceTest;
import ar.edu.unq.desapp.grupoA.services.ExchangeProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ExchangeProductServiceTest extends AbstractServiceTest {

    private UserModel user;
    private Product product;

    @Autowired
    public ExchangeProductService service;
    @Autowired
    protected UserModelTestFactory userModelTestFactory;
    @Autowired
    protected ProductFactory productFactory;
    @Autowired
    protected ExchangeProductRepository exchangeProductRepository;


    @Before
    public void setUp() {
        this.productFactory.createBasicProducts();
        this.user = this.userModelTestFactory.getUser();
        this.product = this.productFactory.getFuelVoucher100();
    }

    @Test
    public void testCorrectExchange() {
        this.user.setPoints(30000);
        this.service.exchangeProduct(user, this.product);
        assertEquals(this.user.getExchanges().size(), 1);
        assertEquals(this.user.getPoints(), 15000);
    }

    @Test(expected = InsufficientPointsException.class)
    public void insuficientPointsToExchange() {
        try {
            this.service.exchangeProduct(user, this.product);
        } catch (InsufficientPointsException excep) {
            assertEquals(excep.getMessage(), "No sufficient points.");
            throw excep;
        }
        assertEquals(this.user.getExchanges().size(), 0);
        assertEquals(this.user.getPoints(), 15000);

    }

    @Test
    public void hasOneMoreExchange() {
        this.user.setPoints(30000);
        assertEquals(0, this.exchangeProductRepository.count());

        this.service.exchangeProduct(user, this.product);
        assertEquals(1, this.exchangeProductRepository.count());
        int cantidad = this.productFactory.getFuelVoucher100().getStock() -1 ;
        assertEquals(49, this.productFactory.getFuelVoucher100().getStock());

    }

    @Test
    public void hasOneLessProductStock() {
        this.user.setPoints(30000);
        this.service.exchangeProduct(user, this.product);
        assertEquals(49, this.productFactory.getFuelVoucher100().getStock());
    }

    @Test(expected = StockNullException.class)
    public void hasNotMoreStock() {
        this.user.setPoints(30000);
        this.product.setStock(0);
        try {
            this.service.exchangeProduct(user, this.product);
        } catch (StockNullException excep) {
            assertEquals(excep.getMessage(), "No more stock for this product.");
            throw excep;
        }
        assertEquals(0, this.productFactory.getFuelVoucher100().getStock());
        assertEquals(0, this.exchangeProductRepository.count());
    }
}
