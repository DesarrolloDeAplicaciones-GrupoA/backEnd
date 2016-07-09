package ar.edu.unq.desapp.grupoA.controllers.requests;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.Interval;

import java.sql.Date;
import java.util.Set;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationBody {
    String nameTravel;
    int fuel;
    int toll;
    @JsonProperty("startPoint") Point startPoint;
    @JsonProperty("endPoint") Point endPoint;
    long inicio;
    long fin;
    Set<Integer> frequency;

    public Route getRouteFromBody(){

        Point start = new Point(0, 0);
        Point end = new Point(0, 0);;

        return new Route(start,end);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Set<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(Set<Integer> frequency) {
        this.frequency = frequency;
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