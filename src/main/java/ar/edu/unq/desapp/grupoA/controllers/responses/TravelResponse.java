package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;

public class TravelResponse {
    private String nameTravel;
    private Route route;
    private Integer id;

    public TravelResponse(String nameTravel, int id, Route route) {
        this.setNameTravel(nameTravel);
        this.setId(id);
        this.setRoute(route);
    }

    public static TravelResponse build(Travel travel) {
        return new TravelResponse(travel.getNameTravel(), travel.getId(), travel.getRoute());
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
}
