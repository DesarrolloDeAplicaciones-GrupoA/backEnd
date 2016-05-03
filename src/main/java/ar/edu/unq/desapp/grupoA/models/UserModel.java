package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.services.scoring.ScoringModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "UserModel")
public class UserModel implements ScoringModel {

    private static final long serialVersionUID = -3495963290665047369L;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Id()
    @GeneratedValue()
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "points")
    private int points;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Vehicle.class)
    @JoinColumn(name = "vehicle_fk")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "userModel")
    private Set<Travel> travels;

    @OneToMany(mappedBy = "driver")
    private Set<Score> driverScores;

    @OneToMany(mappedBy = "accompanist")
    private Set<Score> accompanistScores;


    @Transient
    private List<Exchange> exchanges;
    @Transient
    private List<ApplicationRequest> requestedApplications;
    @OneToMany
    private Set<Message> messagesSend;
    @Transient
    private List<Message> messagesReceived;


    public UserModel() {
        super();
    }


    public UserModel(String fullName, String email) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.accompanistScores = new HashSet<>();
        this.driverScores = new HashSet<>();
        this.exchanges = new ArrayList<>();
        this.travels = new HashSet<>();
        this.points = 0;
        this.requestedApplications = new ArrayList<>();
        this.accompanistScores = new HashSet<>();
        this.messagesSend = new HashSet<>();
        this.messagesReceived = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Score> getDriverScores() {
        return driverScores;
    }

    public Set<Score> getAccompanistScores() {
        return accompanistScores;
    }

    public int getPoints() {
        return points;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void addTravel(Travel travel) {
        this.travels.add(travel);
    }

    public Set<Travel> getTravels() {
        return travels;
    }

    public List<Exchange> getExchanges() {
        return exchanges;
    }

    public void addRequestedApplications(ApplicationRequest request) {
        this.requestedApplications.add(request);
    }

    public void addDriverScore(Score score) {
        this.driverScores.add(score);
    }

    public void addAccompanistScore(Score score) {
        this.accompanistScores.add(score);
    }

    public void addMessageSend(Message messageObjet) {
        this.messagesSend.add(messageObjet);
    }

    public void addMessageReceived(Message messageObjet) {
        this.messagesReceived.add(messageObjet);
    }

    public Set<Message> getMessagesSend() {
        return messagesSend;
    }

    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void removePoints(int points) {
        this.points -= points;
    }

    public List<Score> getAccompanistBadScores() {
        return this.getAccompanistScores().stream().filter((score -> !score.isGood())).collect(Collectors.toList());
    }

    public List<Score> driverBadScores() {
        return this.getDriverScores().stream().filter((score -> !score.isGood())).collect(Collectors.toList());
    }

    public void markBadScoresAsApplied() {
        this.getAccompanistBadScores().stream().forEach(Score::applied);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addExchange(Exchange exchange) {
        this.exchanges.add(exchange);
    }
}