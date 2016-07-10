package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.utils.Point;

public class ApplicationRequestCreationResponse {
    private Integer id;
    private Point upPoint;
    private Point downPoint;

    public ApplicationRequestCreationResponse(int id, Point upPoint, Point downPoint) {
        this.setId(id);
        this.setDownPoint(downPoint);
        this.setUpPoint(upPoint);
    }

    public static ApplicationRequestCreationResponse build(ApplicationRequest applicationRequest) {
        return new ApplicationRequestCreationResponse(applicationRequest.getId(), applicationRequest.getUpPoint(), applicationRequest.getDownPoint());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Point getUpPoint() {
        return upPoint;
    }

    public void setUpPoint(Point upPoint) {
        this.upPoint = upPoint;
    }

    public Point getDownPoint() {
        return downPoint;
    }

    public void setDownPoint(Point downPoint) {
        this.downPoint = downPoint;
    }
}
