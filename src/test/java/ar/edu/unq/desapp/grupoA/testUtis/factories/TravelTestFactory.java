package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

public class TravelTestFactory {

    private Travel travel;

    public Travel getTravelTest() {
        Interval rangeHoures = new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));
        List<Integer> frequency = new ArrayList<Integer>();
        frequency.add(DateTimeConstants.MONDAY);
        frequency.add(DateTimeConstants.WEDNESDAY);
        frequency.add(DateTimeConstants.FRIDAY);
        Route route = new RouteTestFactory().fromConstitucionToCorrientes();
        return (new Travel("Viaje Trabajo", 50, 20, route, rangeHoures, frequency));
    }
}
