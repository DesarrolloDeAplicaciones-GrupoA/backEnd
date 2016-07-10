package ar.edu.unq.desapp.grupoA.models.utils;


import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "Point")
public class Point {
    private static final long serialVersionUID = -3595963299665047378L;

    @Id()
    @GeneratedValue()
    @Column(name = "POINT_ID")
    private int id;

    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false)
    private double longitude;

    public Point() {

    }

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return (p.getLatitude() == this.latitude) && p.getLongitude() == this.getLongitude();
    }

    public int getId() {
        return id;
    }
}
