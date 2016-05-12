package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("rankingService")
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking createRanking(Set<UserModel> userModelSet) {
        Ranking ranking = new Ranking(userModelSet);
        this.rankingRepository.save(ranking);
        return this.rankingRepository.findById(ranking.getId());

    }

    public void rankearATodos(Ranking ranking) {
        ranking.rankearATodos();
    }

    public Set<UserModel> getUsuariosEficiente(Ranking ranking) {
        return ranking.getUsuariosEficientes();
    }
}
