package ar.edu.unq.desapp.grupoA.repositories;



import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;


@Repository("pointRepository")
public class PointRepository extends HibernateGenericDAO<Point> implements GenericRepository<Point> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<Point> getDomainClass() {
        return Point.class;
    }
}

