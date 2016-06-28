package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component("travelTestFactory")
public class TravelTestFactory {

    @Autowired
    private RouteTestFactory routeTestFactory;
    @Autowired
    private TravelRepository travelRepository;

    public Travel getTravelTest() {
        Interval rangeHoures = new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));
        Time from = new Time(rangeHoures.getStartMillis());
        Time to = new Time(rangeHoures.getEndMillis());
        List<Integer> frequency = new ArrayList<Integer>();
        frequency.add(DateTimeConstants.MONDAY);
        frequency.add(DateTimeConstants.WEDNESDAY);
        frequency.add(DateTimeConstants.FRIDAY);
        Route route = this.routeTestFactory.fromConstitucionToCorrientes();
        return (new Travel("Viaje Trabajo", 50, 20, route, from, to, frequency));
    }

    public Travel getTravel(UserModel userModel) {
        Travel travel = this.getTravelTest();
        travel.setUserModel(userModel);
        travelRepository.save(travel);
        return travelRepository.findById(travel.getId());
    }
}
