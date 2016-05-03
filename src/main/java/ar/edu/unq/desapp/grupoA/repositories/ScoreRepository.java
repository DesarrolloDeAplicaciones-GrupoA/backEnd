package ar.edu.unq.desapp.grupoA.repositories;


import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("scoreRepository")
public class ScoreRepository extends HibernateGenericDAO<Score> implements GenericRepository<Score> {
    @Override
    protected Class<Score> getDomainClass() {
        return Score.class;
    }
}
