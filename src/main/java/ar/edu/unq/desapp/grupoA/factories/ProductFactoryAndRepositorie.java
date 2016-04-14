package ar.edu.unq.desapp.grupoA.factories;

import ar.edu.unq.desapp.grupoA.models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactoryAndRepositorie {

    private Map<String, Product> products;

    public ProductFactoryAndRepositorie() {
        this.products = new HashMap<String, Product>();
        Product voucher100 = new Product("Fuel Voucher 100", 50, 15000);
        Product voucher200 = new Product("Fuel Voucher 200", 30, 28000);
        Product oilChange = new Product("Oil Change", 20, 22000);
        this.products.put("voucher100", voucher100);
        this.products.put("voucher200", voucher200);
        this.products.put("oilChange", oilChange);
    }

    public Product getFuelVoucher100() {
        return this.products.get("voucher100");
    }

    public Product getFuelVoucher200() {
        return this.products.get("voucher200");
    }

    public Product getOilChange() {
        return this.products.get("oilChange");
    }
}
