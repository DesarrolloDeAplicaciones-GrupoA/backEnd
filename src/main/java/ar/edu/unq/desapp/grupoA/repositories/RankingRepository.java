package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("rankingRepository")
public class RankingRepository extends HibernateGenericDAO<Ranking> implements GenericRepository<Ranking> {

    private static final long serialVersionUID = -4036325633305672220L;

    @Override
    protected Class<Ranking> getDomainClass() {
        return Ranking.class;
    }
}
