package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.services.scoring.ScoringModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserModel implements ScoringModel {

    private String fullName;
    private String email;
    private Vehicle vehicle;
    private List<Score> driverScores;
    private List<Score> accompanistScores;
    private int points;
    private List<Exchange> exchanges;
    private List<Travel> travels;
    private List<ApplicationRequest> requestedApplications;
    private List<Message> messagesSend;
    private List<Message> messagesReceived;


    public UserModel(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.accompanistScores = new ArrayList<>();
        this.driverScores = new ArrayList<>();
        this.exchanges = new ArrayList<>();
        this.travels = new ArrayList<>();
        this.points = 0;
        this.requestedApplications = new ArrayList<>();
        this.accompanistScores = new ArrayList<>();
        this.messagesSend = new ArrayList<>();
        this.messagesReceived = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public List<Score> getDriverScores() {
        return driverScores;
    }

    public List<Score> getAccompanistScores() {
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

    public List<Travel> getTravels() {
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

    public List<Message> getMessagesSend() {
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