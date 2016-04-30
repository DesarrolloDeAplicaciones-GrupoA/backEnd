package ar.edu.unq.desapp.grupoA.models;

import javax.persistence.*;

@Entity
@Table(name = "Score")
public class Score {



    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne()
    private Travel travel;
    @ManyToOne()
    private Vehicle vehicle;

    private boolean isGood;
    private boolean applied;

    public Score(Travel travel, boolean isGood) {
        this.travel = travel;
        this.isGood = isGood;
        this.applied = false;
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
}
