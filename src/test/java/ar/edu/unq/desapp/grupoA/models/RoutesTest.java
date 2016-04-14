package ar.edu.unq.desapp.grupoA.models;


import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoutesTest {

    @Test
    public void aRouteHaveAStartAndEndPoint() {
        PointFactory factory = new PointFactory();
        Route route = new RouteFactory().fromTo(factory.create(-34.627712, -58.379718), factory.create(-34.603722, -58.382002));
        assertNotNull(route.getStart());
        assertNotNull(route.getEnd());
    }

    @Test
    public void aTwoPointsEquals() {
        PointFactory factory = new PointFactory();
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        assertEquals(p1,p2);
    }
}
