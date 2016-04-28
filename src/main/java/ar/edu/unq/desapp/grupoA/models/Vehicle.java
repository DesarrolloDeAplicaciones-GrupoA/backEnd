package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.Entity;
import ar.edu.unq.desapp.grupoA.services.scoring.ScoringModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Vehicle extends Entity implements ScoringModel {

    private static final long serialVersionUID = -2295963290665047369L;

    private String brand;
    private int capacity;
    private List<Score> scores;
    private UserModel driver;

    public Vehicle(){super();}

    public Vehicle(String brand, int capacity, UserModel driver) {
        super();
        this.brand = brand;
        this.capacity = capacity;
        this.scores = new ArrayList<>();
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Score> getScores() {
        return scores;
    }

    public int getDriverPoints() {
        return this.driver.getPoints();
    }

    public void addVehicleScore(Score score) {
        this.scores.add(score);
    }

    public UserModel getDriver() {
        return driver;
    }

    public List<Score> getBadScores() {
        return this.getScores().stream().filter((score -> !score.isGood())).collect(Collectors.toList());
    }

    public void markBadScoresAsApplied() {
        this.getBadScores().stream().forEach(Score::applied);
    }
}
