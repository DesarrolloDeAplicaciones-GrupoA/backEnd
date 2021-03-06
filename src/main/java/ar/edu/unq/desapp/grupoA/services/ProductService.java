package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.factories.ProductFactory;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFactory productFactory;

    @Transactional
    public Product createProduct(String name, int stock, int pointCost) {
        Product product = new Product(name, stock, pointCost);
        productRepository.save(product);
        return product;
    }
    @Transactional
    public List<Product> findAll() {
        return this.getProductRepository().findAll();
    }

    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Transactional
    public void reduceStock(Product product) {
        product.reduceStock();
        productRepository.update(product);
    }
/*    @PostConstruct
    public void loadData() {
        this.productFactory.createBasicProducts();
    }*/

    public Product getProduct(String name) {
        return this.productFactory.getProductByName(name);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
