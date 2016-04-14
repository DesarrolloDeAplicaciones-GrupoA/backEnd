package ar.edu.unq.desapp.grupoA.models.utils;


public class PointFactory {
    public Point create(double latitude, double longitude) {
        return new Point(latitude, longitude);
    }
}
