package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.models.Exchange;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ExchangeProductRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("exchangeProductService")
public class ExchangeProductService {

    @Autowired
    protected ProductService productService;
    @Autowired
    private ExchangeProductRepository exchangeProductRepository;
    @Autowired
    private UserModelRepository userModelRepository;

    @Transactional
    public Exchange exchangeProduct(UserModel user, Product product) {

        if (user.getPoints() >= product.getPointCost()) {
            Exchange exchange = new Exchange(product, user);
            user.setPoints(user.getPoints() - product.getPointCost());
            user.addExchange(exchange);
            this.userModelRepository.update(user);
            this.exchangeProductRepository.save(exchange);
            this.productService.reduceStock(product);
            return exchange;
        } else {
            throw new InsufficientPointsException("No sufficient points.");
        }

    }
}
