package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationResponse extends ApplicationRequestCreationResponse {

    private TravelResponse travel;

    public ApplicationResponse(int id, Point upPoint, Point downPoint, Travel travel) {
        super(id, upPoint, downPoint);
        this.setTravel(TravelResponse.build(travel));

    }

    public static List<ApplicationResponse> buildMany(List<ApplicationRequest> applicationRequests) {
        return applicationRequests.stream().map(ApplicationResponse::build).collect(Collectors.toList());
    }

    public static ApplicationResponse build(ApplicationRequest applicationRequest) {
        return new ApplicationResponse(applicationRequest.getId(), applicationRequest.getUpPoint(), applicationRequest.getDownPoint(), applicationRequest.getTravel());
    }

    public TravelResponse getTravel() {
        return travel;
    }

    public void setTravel(TravelResponse travel) {
        this.travel = travel;
    }
}
