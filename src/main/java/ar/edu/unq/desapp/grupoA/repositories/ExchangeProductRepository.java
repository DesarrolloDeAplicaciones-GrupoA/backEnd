package ar.edu.unq.desapp.grupoA.repositories;



import ar.edu.unq.desapp.grupoA.models.Exchange;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("exchangeProductRepository")
public class ExchangeProductRepository extends HibernateGenericDAO<Exchange> implements GenericRepository<Exchange> {

    private static final long serialVersionUID = -4036535833305672220L;

    @Override
    protected Class<Exchange> getDomainClass() {
        return Exchange.class;
    }
}
