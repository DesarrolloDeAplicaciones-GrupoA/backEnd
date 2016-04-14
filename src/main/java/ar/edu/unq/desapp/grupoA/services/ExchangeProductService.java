package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.exceptions.InsufficientPointsException;
import ar.edu.unq.desapp.grupoA.models.Exchange;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.UserModel;

public class ExchangeProductService {

    public Exchange exchangeProduct(UserModel user, Product product) {

        if (user.getPoints() >= product.getPointCost()) {
            Exchange exchange = new Exchange(product, user);
            //Hay que descontar uno del stock de productos
            user.setPoints(user.getPoints() - product.getPointCost());
            user.addExchange(exchange);
            return exchange;
        } else {
            throw new InsufficientPointsException("No sufficient points.");
        }

    }
}
