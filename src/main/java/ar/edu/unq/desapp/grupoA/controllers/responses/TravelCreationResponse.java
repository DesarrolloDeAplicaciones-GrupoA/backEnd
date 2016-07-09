package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Travel;

import java.util.Set;

public class TravelCreationResponse {
    String nameTravel;
    int fuel;
    int toll;
    double routePuntoInicioLatitud;
    double routePuntoInicioLongitud;
    double routePuntoFinLatitud;
    double routePuntoFinLongitud;
    long inicio;
    long fin;
    Set<Integer> frequency;
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

    public Set<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(Set<Integer> frequency) {
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

    public TravelCreationResponse(String nameTravel, int fuel, int toll, double routePuntoInicioLatitud, double routePuntoInicioLongitud, double routePuntoFinLatitud, double routePuntoFinLongitud, long inicio, long fin, Set<Integer> frequency, Integer id) {
        this.nameTravel = nameTravel;
        this.fuel = fuel;
        this.toll = toll;
        this.routePuntoInicioLatitud = routePuntoInicioLatitud;
        this.routePuntoInicioLongitud = routePuntoInicioLongitud;
        this.routePuntoFinLatitud = routePuntoFinLatitud;
        this.routePuntoFinLongitud = routePuntoFinLongitud;
        this.inicio = inicio;
        this.fin = fin;
        this.frequency = frequency;
        this.id = id;
    }

    public static TravelCreationResponse build(Travel travel) {
        return new TravelCreationResponse(travel.getNameTravel(), travel.getFuelCost(), travel.getTollCost(),
                travel.getRoute().getStart().getLatitude(), travel.getRoute().getStart().getLongitude(),
                travel.getRoute().getEnd().getLatitude(), travel.getRoute().getEnd().getLongitude(), travel.getRangeFrom().getTime(),
                travel.getRangeTo().getTime(), travel.getFrequency(), travel.getId());
    }
}
