package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.joda.time.Interval;

import java.util.List;


public class TravelAdding {

    public void createTravel(UserModel user, String nameTravel, int fuel, int toll, Route route, Interval rangeHours, List<Integer> frequency) {
        user.addTravel(new Travel(nameTravel, fuel, toll, route, rangeHours, frequency));
    }
}
