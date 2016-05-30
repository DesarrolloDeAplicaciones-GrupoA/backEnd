package ar.edu.unq.desapp.grupoA.controllers.requests;

import ar.edu.unq.desapp.grupoA.models.Route;
import org.joda.time.Interval;
import java.util.List;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationBody {
    String nameTravel;
    int fuel;
    int toll;
    Route route;
    Interval rangeHours;
    List<Integer> frequency;

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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Interval getRangeHours() {
        return rangeHours;
    }

    public void setRangeHours(Interval rangeHours) {
        this.rangeHours = rangeHours;
    }

    public List<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(List<Integer> frequency) {
        this.frequency = frequency;
    }
}
