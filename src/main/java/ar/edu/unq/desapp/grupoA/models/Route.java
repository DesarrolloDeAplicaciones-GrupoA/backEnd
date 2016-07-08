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

    @ManyToOne
    private Point end;
    @ManyToOne
    private Point start;
    @Column(name = "title")
    private String title;

    public Route(String title, Point start, Point end) {
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
