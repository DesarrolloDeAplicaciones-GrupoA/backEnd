package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;

import java.util.Set;

public class TravelResponse {
    private String nameTravel;
    private Route route;
    private Integer id;
    private Integer toll;
    private Integer fuel;
    private Set<Integer> frequency;

    public TravelResponse(String nameTravel, int id, Route route, Integer toll, Set<Integer> frequency, Integer fuel) {
        this.setNameTravel(nameTravel);
        this.setId(id);
        this.setRoute(route);
        this.setToll(toll);
        this.setFrequency(frequency);
        this.setFuel(fuel);
    }

    public static TravelResponse build(Travel travel) {
        return new TravelResponse(travel.getNameTravel(), travel.getId(), travel.getRoute(), travel.getTollCost(), travel.getFrequency(), travel.getFuelCost());
    }


    public String getNameTravel() {
        return nameTravel;
    }

    public void setNameTravel(String nameTravel) {
        this.nameTravel = nameTravel;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToll() {
        return toll;
    }

    public void setToll(Integer toll) {
        this.toll = toll;
    }

    public Set<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(Set<Integer> frequency) {
        this.frequency = frequency;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }
}
