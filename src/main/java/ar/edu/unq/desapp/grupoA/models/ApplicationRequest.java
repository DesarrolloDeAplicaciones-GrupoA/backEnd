package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.Point;
import org.joda.time.DateTime;

public class ApplicationRequest {


    private Point upPoint;
    private DateTime dateTime;
    private UserModel requester;
    private Travel travel;
    private Point downPoint;
    private ApplicationRequestState state;

    public ApplicationRequest(UserModel requester, Travel travel, DateTime dateTime, Point upPoint, Point downpoint) {
        this.requester = requester;
        this.travel = travel;
        this.dateTime = dateTime;
        this.upPoint = upPoint;
        this.downPoint = downpoint;
        this.state = new PendingApplication(this);
    }


    public UserModel getRequester() {
        return requester;
    }

    public Travel getTravel() {
        return travel;
    }

    public boolean isPending() {
        return this.state.isPending();
    }

    public void approve() {
        this.state.approve();
    }

    public boolean isApproved() {
        return state.isApproved();
    }

    public void setState(ApplicationRequestState state) {
        this.state = state;
    }

    public boolean isRejected() {
        return state.isReject();
    }

    public void reject() {
        this.state.reject();
    }
}
