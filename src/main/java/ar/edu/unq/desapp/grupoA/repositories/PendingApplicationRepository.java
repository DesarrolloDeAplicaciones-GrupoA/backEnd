package ar.edu.unq.desapp.grupoA.repositories;


import ar.edu.unq.desapp.grupoA.models.PendingApplication;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("pendingApplicationRepository")
public class PendingApplicationRepository extends HibernateGenericDAO<PendingApplication> implements GenericRepository<PendingApplication> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<PendingApplication> getDomainClass() {
        return PendingApplication.class;
    }
}

