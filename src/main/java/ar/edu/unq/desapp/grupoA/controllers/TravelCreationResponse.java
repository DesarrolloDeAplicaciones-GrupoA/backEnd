package ar.edu.unq.desapp.grupoA.controllers;

import ar.edu.unq.desapp.grupoA.controllers.responses.VehicleCreationResponse;
import ar.edu.unq.desapp.grupoA.models.Travel;

/**
 * Created by damian on 30/05/16.
 */
public class TravelCreationResponse {
    private String name;

    public TravelCreationResponse(String nameTravel) {
        this.name = nameTravel;
    }

    public static TravelCreationResponse build(Travel travel) {
        return new TravelCreationResponse(travel.getNameTravel());
    }
}
