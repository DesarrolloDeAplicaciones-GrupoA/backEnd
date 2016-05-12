package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.models.utils.PointFactory;
import ar.edu.unq.desapp.grupoA.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("pointTestFactory")
public class PointTestFactory extends PointFactory {

    public Point getPointOne() {
        return this.create(-34.627712, -58.379718);
    }

    public Point getPointTwo() {
        return this.create(-34.603722, -58.382002);
    }
}
