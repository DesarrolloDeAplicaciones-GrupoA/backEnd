package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;

import java.util.List;
import java.util.Set;

public class TravelCreationResponse {
    String nameTravel;
    int fuel;
    int toll;
    Route route;
    long inicio;
    long fin;
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

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    public TravelCreationResponse(String nameTravel, int fuel, int toll, Route route, long inicio, long fin, List<Integer> frequency, Integer id) {
        this.nameTravel = nameTravel;
        this.fuel = fuel;
        this.toll = toll;
        this.route = route;
        this.inicio = inicio;
        this.fin = fin;
        this.frequency = frequency;
        this.id = id;
    }


    public static TravelCreationResponse build(Travel travel) {
        return new TravelCreationResponse(travel.getNameTravel(), travel.getFuelCost(), travel.getTollCost(), travel.getRoute(), travel.getRangeFrom().getTime(), travel.getRangeTo().getTime(), travel.getFrequency(), travel.getId());
    }
}
