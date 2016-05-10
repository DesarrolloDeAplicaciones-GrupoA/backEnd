package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("rankingService")
public class RankingService {


    public Ranking createRanking(Set<UserModel> userModelSet) {

        return new Ranking(userModelSet);

    }

    public RankingService() {
    }

    public void rankearATodos(Ranking ranking) {
        ranking.rankearATodos();
    }

    public Set<UserModel> getUsuariosEficiente(Ranking ranking) {
        return ranking.getUsuariosEficientes();
    }
}
