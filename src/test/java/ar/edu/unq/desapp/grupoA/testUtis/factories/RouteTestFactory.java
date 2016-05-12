package ar.edu.unq.desapp.grupoA.testUtis.factories;


import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import org.springframework.stereotype.Component;

@Component("routeTestFactory")
public class RouteTestFactory extends RouteFactory {

    public Route fromConstitucionToCorrientes() {
        PointFactory factory = this.getPointFactory();

        return this.fromTo(factory.create(-34.627712, -58.379718), factory.create(-34.603722, -58.382002));
    }
}
