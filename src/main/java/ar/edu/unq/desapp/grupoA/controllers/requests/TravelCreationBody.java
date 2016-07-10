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
    double inicioLatitud;
    double inicioLongitud;
    double finLatitud;
    double finLongitud;
    long inicio;
    long fin;
    Set<Integer> frequency;

    public Route getRouteFromBody(){

        Point start = new Point(inicioLatitud, inicioLongitud);
        Point end = new Point(finLatitud, finLongitud);

        return new Route(start,end);
    }

    public double getInicioLatitud() {
        return inicioLatitud;
    }

    public void setInicioLatitud(double inicioLatitud) {
        this.inicioLatitud = inicioLatitud;
    }

    public double getInicioLongitud() {
        return inicioLongitud;
    }

    public void setInicioLongitud(double inicioLongitud) {
        this.inicioLongitud = inicioLongitud;
    }

    public double getFinLatitud() {
        return finLatitud;
    }

    public void setFinLatitud(double finLatitud) {
        this.finLatitud = finLatitud;
    }

    public double getFinLongitud() {
        return finLongitud;
    }

    public void setFinLongitud(double finLongitud) {
        this.finLongitud = finLongitud;
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