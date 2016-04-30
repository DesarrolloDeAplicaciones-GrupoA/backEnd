package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.services.scoring.ScoringModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "Vehicle")
public class Vehicle implements ScoringModel {

    private static final long serialVersionUID = -2295963290665047369L;


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Id()
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "capacity")
    private int capacity;
    @OneToOne(mappedBy = "vehicle")
    private UserModel driver;

    @OneToMany(mappedBy = "vehicle")
    private Set<Score> scores;

    public Vehicle() {
        super();
    }

    public Vehicle(String brand, int capacity, UserModel driver) {
        super();
        this.brand = brand;
        this.capacity = capacity;
        this.scores = new HashSet<>();
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Score> getScores() {
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
