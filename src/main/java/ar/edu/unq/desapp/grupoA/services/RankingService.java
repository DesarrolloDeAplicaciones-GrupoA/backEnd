package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;

import java.util.List;

public class RankingService {


    public Ranking createRanking(List<UserModel> userModelList) {

        return new Ranking(userModelList);

    }

    public RankingService() {
    }

    public void rankearATodos(Ranking ranking) {
        ranking.rankearATodos();
    }

    public List<UserModel> getUsuariosEficiente(Ranking ranking) {
        return ranking.getUsuariosEficientes();
    }
}
