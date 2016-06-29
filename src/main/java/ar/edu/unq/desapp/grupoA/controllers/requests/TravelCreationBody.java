package ar.edu.unq.desapp.grupoA.controllers.requests;

import ar.edu.unq.desapp.grupoA.models.Route;
import org.joda.time.Interval;

import java.sql.Date;
import java.util.List;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationBody {
    String nameTravel;
    int fuel;
    int toll;
    String route;
    long inicio;
    long fin;
    List<Integer> frequency;


    public List<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(List<Integer> frequency) {
        this.frequency = frequency;
    }


    public Route getRouteFromString() {
        return new Route();
    }

    public Interval getRangeHours() {
        return new Interval(inicio, fin);
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

    public Date getInicio() {
        return new Date(this.inicio);
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return new Date(this.fin);
    }

    public void setFin(long fin) {
        this.fin = fin;
    }


}