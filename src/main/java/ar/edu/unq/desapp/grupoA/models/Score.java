package ar.edu.unq.desapp.grupoA.models;

import javax.persistence.*;

@Entity
@Table(name = "Score")
public class Score {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne()
    private Travel travel;
    @ManyToOne(optional = true)
    private Vehicle vehicle;
    @ManyToOne(optional = true)
    private UserModel accompanist;
    @ManyToOne(optional = true)
    private UserModel driver;

    private boolean isGood;
    private boolean applied;

    public Score(Travel travel, boolean isGood) {
        this.travel = travel;
        this.isGood = isGood;
        this.applied = false;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public boolean isGood() {
        return isGood;
    }

    public Travel getTravel() {
        return travel;
    }

    public void applied() {
        this.applied = true;
    }

    public void setDriver(UserModel driver) {
        this.driver = driver;
    }

    public void setAccompanist(UserModel accompanist) {
        this.accompanist = accompanist;
    }
}
