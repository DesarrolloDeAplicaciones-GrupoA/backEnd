package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("routeRepository")
public class RouteRepository extends HibernateGenericDAO<Route> implements GenericRepository<Route> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<Route> getDomainClass() {
        return Route.class;
    }
}

