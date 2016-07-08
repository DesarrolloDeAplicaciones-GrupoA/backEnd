package ar.edu.unq.desapp.grupoA.factories;


import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import ar.edu.unq.desapp.grupoA.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("routeFactory")
public class RouteFactory {

    public RouteFactory(){}

    @Autowired
    private PointFactory pointFactory;

    @Autowired
    private RouteRepository routeRepository;

    public Route fromTo(Point start, Point end) {
        Route route = new Route(start, end);
        this.routeRepository.save(route);
        return this.routeRepository.findById(route.getId());
    }

    public PointFactory getPointFactory() {
        return pointFactory;
    }

    public void setPointFactory(PointFactory pointFactory) {
        this.pointFactory = pointFactory;
    }

    public RouteRepository getRouteRepository() {
        return routeRepository;
    }

    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
}
