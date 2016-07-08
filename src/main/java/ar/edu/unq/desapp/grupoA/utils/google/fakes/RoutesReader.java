package ar.edu.unq.desapp.grupoA.utils.google.fakes;

import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Component("routesReader")
public class RoutesReader {

    private RouteFactory routeFactory;
    private PointFactory pointFactory;

    public List<Route> build() {
        ObjectMapper mapper = new ObjectMapper();

        InputStream is = getClass().getClassLoader().getResourceAsStream("fixtures/routes.json");

        List parsed;
        try {
            parsed = mapper.readValue(is, List.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<Route> routes = new ArrayList<>();
        for (Object o : parsed) {
            LinkedHashMap object = (LinkedHashMap) o;
            LinkedHashMap start = (LinkedHashMap) object.get("start");
            LinkedHashMap end = (LinkedHashMap) object.get("end");
            Point startPoint = this.getPointFactory().create((Double) start.get("latitude"), (Double) start.get("longitude"));
            Point endPoint = this.getPointFactory().create((Double) end.get("latitude"), (Double) end.get("longitude"));
            routes.add(this.getRouteFactory().fromTo(startPoint, endPoint));
        }
        return routes;

    }

    public RouteFactory getRouteFactory() {
        return routeFactory;
    }

    @Autowired
    public void setRouteFactory(RouteFactory routeFactory) {
        this.routeFactory = routeFactory;
    }

    public PointFactory getPointFactory() {
        return pointFactory;
    }

    @Autowired
    public void setPointFactory(PointFactory pointFactory) {
        this.pointFactory = pointFactory;
    }
}
