package ar.edu.unq.desapp.grupoA.repositories;


import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("applicationRequestRepository")
public class ApplicationRequestRepository extends HibernateGenericDAO<ApplicationRequest> implements GenericRepository<ApplicationRequest> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<ApplicationRequest> getDomainClass() {
        return ApplicationRequest.class;
    }
}
