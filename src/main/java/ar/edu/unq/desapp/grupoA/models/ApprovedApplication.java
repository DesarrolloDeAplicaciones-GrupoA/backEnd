package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ApprovedApplication extends ApplicationRequestState {

    @Override
    public boolean isPending() {
        return false;
    }

    @Override
    public boolean isApproved() {
        return true;
    }

    @Override
    public boolean isReject() {
        return false;
    }

    @Override
    public void approve() {

        throw new InvalidTransitionException("Allready approved");

    }

    @Override
    public void reject() {
        throw new InvalidTransitionException("can not pass from approved to reject");
    }
}
