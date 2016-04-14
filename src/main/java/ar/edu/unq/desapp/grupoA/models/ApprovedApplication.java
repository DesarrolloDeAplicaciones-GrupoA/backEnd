package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;

/**
 * Created by Loiacono.P671 on 09/04/2016.
 */
public class ApprovedApplication implements ApplicationRequestState {
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
