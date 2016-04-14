package ar.edu.unq.desapp.grupoA.factories;


import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.utils.Point;

public class RouteFactory {

    public Route fromTo(Point start, Point end) {
        return new Route(start, end);
    }
}
