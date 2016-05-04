package ar.edu.unq.desapp.grupoA.models;


import javax.persistence.*;

@Entity
@Table(name = "RejectedApplication")
public abstract class ApplicationRequestState {
    @Id()
    @GeneratedValue()
    @Column(name = "ROUTE_ID")
    private int id;

    public abstract boolean isPending();

    public abstract boolean isApproved();

    public abstract boolean isReject();

    public abstract void approve();

    public abstract void reject();


}
