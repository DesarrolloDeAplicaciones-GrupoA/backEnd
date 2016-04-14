package ar.edu.unq.desapp.grupoA.models.utils;


public class Point {
    private double latitude;
    private double longitude;

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
        return (p.getLatitude()  == this.latitude) && p.getLongitude() == this.getLongitude();
    }
}
