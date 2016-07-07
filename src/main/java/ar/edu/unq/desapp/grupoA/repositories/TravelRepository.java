package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("travelRepository")
public class TravelRepository extends HibernateGenericDAO<Travel> implements GenericRepository<Travel> {

    public TravelRepository(){}

    private static final long serialVersionUID = -4036535812105672220L;

    @Override
    protected Class<Travel> getDomainClass() {
        return Travel.class;
    }
}
