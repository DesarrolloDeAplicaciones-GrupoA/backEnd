package ar.edu.unq.desapp.grupoA.models.utils;


import ar.edu.unq.desapp.grupoA.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("pointFactory")
public class PointFactory {


    @Autowired
    private PointRepository pointRepository;

    public PointFactory(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public PointFactory() {

    }

    @Transactional
    public Point create(double latitude, double longitude) {
        Point point = new Point(latitude, longitude);
        this.getPointRepository().save(point);
        return this.getPointRepository().findById(point.getId());
    }

    public Point createFrom(String latitude, String longitude) {
        return this.create(Double.parseDouble(latitude), Double.parseDouble(longitude));
    }

    public PointRepository getPointRepository() {
        return pointRepository;
    }

    public void setPointRepository(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }
}
