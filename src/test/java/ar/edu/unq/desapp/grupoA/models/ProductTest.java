package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.factories.ProductFactoryAndRepositorie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    private ProductFactoryAndRepositorie productFactory;

    @Before
    public void setUp() {
        this.productFactory = new ProductFactoryAndRepositorie();
    }

    @Test
    public void testVoucher() {
        assertEquals(this.productFactory.getFuelVoucher100().getName(), "Fuel Voucher 100");
        assertEquals(this.productFactory.getFuelVoucher100().getPointCost(), 15000);
        assertEquals(this.productFactory.getFuelVoucher200().getName(), "Fuel Voucher 200");
        assertEquals(this.productFactory.getFuelVoucher200().getPointCost(), 28000);
    }

    @Test
    public void testOilChange() {
        assertEquals(this.productFactory.getOilChange().getName(), "Oil Change");
        assertEquals(this.productFactory.getOilChange().getPointCost(), 22000);
    }

}

