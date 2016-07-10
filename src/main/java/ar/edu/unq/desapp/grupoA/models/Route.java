package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.Point;

import javax.persistence.*;

@Entity
@Table(name = "Route")
public class Route {

    public Route(){}

    @Id()
    @GeneratedValue()
    @Column(name = "ROUTE_ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Point end;
    @ManyToOne(cascade = CascadeType.ALL)
    private Point start;

    public Route(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

    public int getId() {
        return id;
    }

}
