package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;

import javax.persistence.*;

@Entity
@Table(name = "RejectedApplication")
public class RejectedApplication implements ApplicationRequestState {

    @Id()
    @GeneratedValue()
    @Column(name = "ROUTE_ID")
    private int id;

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
