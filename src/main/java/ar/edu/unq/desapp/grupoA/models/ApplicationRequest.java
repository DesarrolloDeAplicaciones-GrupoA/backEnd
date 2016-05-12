package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.Point;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PendingApplication")
public class ApplicationRequest {

    @Id()
    @GeneratedValue()
    @Column(name = "APLICATION_REQUEST_ID")
    private int id;

    @ManyToOne
    private Point upPoint;
    @Column(name = "date_time")
    private Date dateTime;
    @ManyToOne
    private UserModel requester;
    @ManyToOne
    private Travel travel;
    @ManyToOne
    private Point downPoint;
    @OneToOne(cascade = CascadeType.ALL)
    private ApplicationRequestState state;

    public ApplicationRequest(UserModel requester, Travel travel, Date dateTime, Point upPoint, Point downpoint) {
        this.requester = requester;
        this.travel = travel;
        this.dateTime = dateTime;
        this.upPoint = upPoint;
        this.downPoint = downpoint;
        this.state = new PendingApplication(this);
    }

    public ApplicationRequestState getState() {
        return this.state;
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
