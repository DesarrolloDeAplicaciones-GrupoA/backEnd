package ar.edu.unq.desapp.grupoA.models;


import javax.persistence.*;

@Entity
@Table(name = "ApplicationRequestState")
public abstract class ApplicationRequestState {
    @Id()
    @GeneratedValue()
    @Column(name = "APPLICATION_REQUEST_STATE_ID")
    private int id;

    public abstract boolean isPending();

    public abstract boolean isApproved();

    public abstract boolean isReject();

    public abstract void approve();

    public abstract void reject();


}
