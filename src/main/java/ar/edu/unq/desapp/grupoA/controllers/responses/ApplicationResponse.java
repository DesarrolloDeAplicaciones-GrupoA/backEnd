package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationResponse extends ApplicationRequestCreationResponse {

    private TravelResponse travel;
    private UserResponse requester;
    private Boolean isRejected;
    private Boolean isApproved;
    private Boolean isPending;

    public ApplicationResponse(int id, Point upPoint, Point downPoint, Travel travel, Boolean isApproved, Boolean isPending, Boolean isRejected, UserModel requester) {
        super(id, upPoint, downPoint);
        this.setTravel(TravelResponse.build(travel));
        this.setApproved(isApproved);
        this.setPending(isPending);
        this.setRejected(isRejected);
        this.setRequester(UserResponse.build(requester));
    }

    public static List<ApplicationResponse> buildMany(List<ApplicationRequest> applicationRequests) {
        return applicationRequests.stream().map(ApplicationResponse::build).collect(Collectors.toList());
    }

    public static ApplicationResponse build(ApplicationRequest applicationRequest) {
        return new ApplicationResponse(
                applicationRequest.getId(),
                applicationRequest.getUpPoint(),
                applicationRequest.getDownPoint(),
                applicationRequest.getTravel(),
                applicationRequest.isApproved(),
                applicationRequest.isPending(),
                applicationRequest.isRejected(),
                applicationRequest.getRequester()
        );
    }

    public TravelResponse getTravel() {
        return travel;
    }

    public void setTravel(TravelResponse travel) {
        this.travel = travel;
    }

    public Boolean getRejected() {
        return isRejected;
    }

    public void setRejected(Boolean rejected) {
        isRejected = rejected;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public UserResponse getRequester() {
        return requester;
    }

    public void setRequester(UserResponse requester) {
        this.requester = requester;
    }
}
