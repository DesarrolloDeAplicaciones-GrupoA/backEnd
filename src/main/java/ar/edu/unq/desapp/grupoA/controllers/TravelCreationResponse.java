package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.VehicleCreationResponse;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
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

    public TravelCreationResponse(String nameTravel, int fuel, int toll, Integer id) {
        this.nameTravel = nameTravel;
        this.fuel = fuel;
        this.toll = toll;
        this.id = id;
    }

    public static TravelCreationResponse build(Travel travel) {
        return new TravelCreationResponse(travel.getNameTravel(), travel.getFuelCost(), travel.getTollCost(), travel.getId());
    }
}
