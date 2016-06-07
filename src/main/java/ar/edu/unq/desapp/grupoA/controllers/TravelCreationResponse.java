package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.VehicleCreationResponse;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.Interval;

import java.util.List;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationResponse {
    String nameTravel;
    int fuel;
    int toll;
    Route route;
    Interval rangeHours;
    List<Integer> frequency;
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TravelCreationResponse(String nameTravel, int fuel, int toll, Route route, Interval rangeHours, List<Integer> frequency, Integer id) {
        this.nameTravel = nameTravel;
        this.fuel = fuel;
        this.toll = toll;
        this.route = route;
        this.rangeHours = rangeHours;
        this.frequency = frequency;
        this.id = id;
    }

    public static TravelCreationResponse build(Travel travel) {
        return new TravelCreationResponse(travel.getNameTravel(), travel.getFuelCost(), travel.getTollCost(), travel.getRoute(), travel.getRangeHours(), travel.getFrequency(),  travel.getId());
    }
}
