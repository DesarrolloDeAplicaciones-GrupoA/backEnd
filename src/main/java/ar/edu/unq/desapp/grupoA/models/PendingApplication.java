package ar.edu.unq.desapp.grupoA.models;

/**
 * Created by Loiacono.P671 on 09/04/2016.
 */
public class PendingApplication implements ApplicationRequestState {
    private ApplicationRequest applicationRequest;

    public PendingApplication(ApplicationRequest applicationRequest) {
        this.applicationRequest = applicationRequest;
    }

    @Override
    public boolean isPending() {
        return true;
    }

    @Override
    public boolean isApproved() {
        return false;
    }

    @Override
    public boolean isReject() {
        return false;
    }

    @Override
    public void approve() {

        this.applicationRequest.setState(new ApprovedApplication());

    }

    @Override
    public void reject() {

        this.applicationRequest.setState(new RejectedApplication());

    }
}
