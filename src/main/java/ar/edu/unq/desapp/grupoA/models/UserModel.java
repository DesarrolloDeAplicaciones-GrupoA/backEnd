package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.oauth.GoogleOauthCredential;
import ar.edu.unq.desapp.grupoA.services.scoring.ScoringModel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "UserModel")
@XmlRootElement(name = "userModel")
public class UserModel implements ScoringModel {

    private static final long serialVersionUID = -3495963290665047369L;

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
    @Column(name = "picture")
    private String picture;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Vehicle.class)
    @JoinColumn(name = "vehicle_fk")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "userModel", fetch = FetchType.EAGER)
    private Set<Travel> travels;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    private Set<Score> driverScores;

    @OneToMany(mappedBy = "accompanist", fetch = FetchType.EAGER)
    private Set<Score> accompanistScores;

    @OneToMany(mappedBy = "userModel", fetch = FetchType.EAGER)
    private Set<Exchange> exchanges;

    @OneToMany(mappedBy = "requester", fetch = FetchType.EAGER)
    private List<ApplicationRequest> requestedApplications;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    private Set<Message> messagesSend;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    private Set<Message> messagesReceived;

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    private GoogleOauthCredential googleOauthCredential;


    public UserModel() {
    }

    public UserModel(String fullName, String email) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.accompanistScores = new HashSet<>();
        this.driverScores = new HashSet<>();
        this.exchanges = new HashSet<>();
        this.travels = new HashSet<>();
        this.points = 0;
        this.requestedApplications = new ArrayList<>();
        this.accompanistScores = new HashSet<>();
        this.messagesSend = new HashSet<>();
        this.messagesReceived = new HashSet<>();
    }


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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

    public Set<Exchange> getExchanges() {
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

    public Set<Message> getMessagesReceived() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public GoogleOauthCredential getGoogleOauthCredential() {
        return googleOauthCredential;
    }

    public void setGoogleOauthCredential(GoogleOauthCredential googleOauthCredential) {
        this.googleOauthCredential = googleOauthCredential;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
