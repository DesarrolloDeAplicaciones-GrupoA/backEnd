package ar.edu.unq.desapp.grupoA.models;


import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import ar.edu.unq.desapp.grupoA.services.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoutesTest extends AbstractServiceTest{

    @Autowired
    private PointFactory pointFactory;
    @Autowired
    private RouteFactory routeFactory;

    @Test
    public void aRouteHaveAStartAndEndPoint() {
        Route route = this.routeFactory.fromTo(StringUtils.getRandomString(), this.pointFactory.create(-34.627712, -58.379718), this.pointFactory.create(-34.603722, -58.382002));
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
