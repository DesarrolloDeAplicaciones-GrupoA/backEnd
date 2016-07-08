package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("travelRepository")
public class TravelRepository extends HibernateGenericDAO<Travel> implements GenericRepository<Travel> {

    public TravelRepository() {
    }

    private static final long serialVersionUID = -4036535812105672220L;

    @Override
    protected Class<Travel> getDomainClass() {
        return Travel.class;
    }

    public List<Travel> findByText(String text) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.like("nameTravel", text, MatchMode.ANYWHERE));
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Travel>) cr.list();
    }
}
