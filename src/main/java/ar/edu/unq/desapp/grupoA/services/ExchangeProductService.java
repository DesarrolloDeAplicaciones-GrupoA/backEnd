package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.models.Exchange;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ExchangeProductRepository;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("exchangeProductService")
public class ExchangeProductService {


    @Autowired
    private ExchangeProductRepository exchangeProductRepository;

    @Transactional
    public Exchange exchangeProduct(UserModel user, Product product) {

        if (user.getPoints() >= product.getPointCost()) {
            Exchange exchange = new Exchange(product, user);
            //Hay que descontar uno del stock de productos
            user.setPoints(user.getPoints() - product.getPointCost());
            user.addExchange(exchange);
            this.exchangeProductRepository.save(exchange);
            return exchange;
        } else {
            throw new InsufficientPointsException("No sufficient points.");
        }

    }
}
