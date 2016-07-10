package ar.edu.unq.desapp.grupoA.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PendingApplication extends ApplicationRequestState {

    @OneToOne(targetEntity = ApplicationRequest.class)
    private ApplicationRequest applicationRequest;

    public PendingApplication() {

    }

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
