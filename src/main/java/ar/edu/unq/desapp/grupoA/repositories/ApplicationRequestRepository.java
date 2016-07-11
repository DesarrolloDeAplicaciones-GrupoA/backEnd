package ar.edu.unq.desapp.grupoA.repositories;


import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("applicationRequestRepository")
public class ApplicationRequestRepository extends HibernateGenericDAO<ApplicationRequest> implements GenericRepository<ApplicationRequest> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<ApplicationRequest> getDomainClass() {
        return ApplicationRequest.class;
    }

    public List<ApplicationRequest> findForUser(UserModel sender) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("requester", sender));
        return (List<ApplicationRequest>) cr.list();
    }

    public List<ApplicationRequest> findForReceiver(UserModel sender) {
        Criteria c = this.getSession().createCriteria(this.getDomainClass(), "application");
        c.createAlias("application.travel", "travel"); // inner join by default
        c.add(Restrictions.eq("travel.userModel", sender));
        return (List<ApplicationRequest>) c.list();
    }
}
