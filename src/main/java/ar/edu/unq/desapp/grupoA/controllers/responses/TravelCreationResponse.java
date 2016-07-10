package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Travel;

import java.util.Set;

public class TravelCreationResponse {
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

    public TravelCreationResponse(String nameTravel, int fuel, int toll, double inicioLatitud, double inicioLongitud, double finLatitud, double finLongitud, long inicio, long fin, Set<Integer> frequency, Integer id) {
        this.nameTravel = nameTravel;
        this.fuel = fuel;
        this.toll = toll;
        this.inicioLatitud = inicioLatitud;
        this.inicioLongitud = inicioLongitud;
        this.finLatitud = finLatitud;
        this.finLongitud = finLongitud;
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
