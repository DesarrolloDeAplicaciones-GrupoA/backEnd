package ar.edu.unq.desapp.grupoA.controllers.responses;

/**
 * Created by damian on 08/07/16.
 */
public class PointResponse {
    private Integer id;
    private double latitude;
    private double longitude;

    public PointResponse(Integer id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
