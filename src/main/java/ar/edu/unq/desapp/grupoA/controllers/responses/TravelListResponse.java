package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Travel;

import java.util.List;
import java.util.stream.Collectors;

public class TravelListResponse {
    public static List<TravelCreationResponse> build(List<Travel> travels) {
        return travels.stream().map(TravelCreationResponse::build).collect(Collectors.toList());
    }
}
