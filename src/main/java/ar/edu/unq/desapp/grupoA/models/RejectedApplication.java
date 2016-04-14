package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;

public class RejectedApplication implements ApplicationRequestState {
    @Override
    public boolean isPending() {
        return false;
    }

    @Override
    public boolean isApproved() {
        return false;
    }

    @Override
    public boolean isReject() {
        return true;
    }

    @Override
    public void approve() {

        throw new InvalidTransitionException("can not pass from rejected to approved");

    }

    @Override
    public void reject() {
        throw new InvalidTransitionException("Already rejected");
    }

}
