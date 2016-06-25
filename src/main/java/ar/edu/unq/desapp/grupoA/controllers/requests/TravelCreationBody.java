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
    String inicio;
    String fin;
    String frequency;

    public List<Integer> getFrequencyFromString() {
        List<Integer> frequency = new ArrayList<>();
        frequency.add(1);
        return frequency;
    }

    public Route getRouteFromString() {
        return new Route();
    }

    public Interval getRangeHours() {
        return new Interval(10000,1000);
    }

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

    public void setRoute(String route) {
        this.route = route;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }


}