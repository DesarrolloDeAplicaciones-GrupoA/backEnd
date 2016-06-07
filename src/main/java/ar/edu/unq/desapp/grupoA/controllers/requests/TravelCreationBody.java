package ar.edu.unq.desapp.grupoA.controllers.requests;

import ar.edu.unq.desapp.grupoA.models.Route;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationBody {
    String nameTravel;
    int fuel;
    int toll;
    String route;
    String rangeHours;
    String frequency;

    public String getNameTravel() {
        return nameTravel;
    }

    public void setNameTravel(String nameTravel) {
        this.nameTravel = nameTravel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getToll() {
        return toll;
    }

    public void setToll(int toll) {
        this.toll = toll;
    }

    public String getRoute() {
        return route;
    }

    public Route getRouteFromString() {
        return new Route();
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRangeHours() {
        return rangeHours;
    }

    public Interval getRangeHoursFromString() {
        return new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));
    }

    public void setRangeHours(String rangeHours) {
        this.rangeHours = rangeHours;
    }

    public String getFrequency() {
        return frequency;
    }

    public List<Integer> getFrequencyFromString() {
        List<Integer> frequency = new ArrayList<>();
        frequency.add(1);
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
