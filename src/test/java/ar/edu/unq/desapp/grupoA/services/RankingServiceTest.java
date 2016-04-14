package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RankingServiceTest {

    private RankingService rankingService;
    private Ranking ranking;

    @Before
    public void setUp() {
        ArrayList<UserModel> userList = new ArrayList<>();
        userList.add(new UserModel("foo bar", "fooba@@@"));
        userList.add(new UserModel("foo bar12", "fooba@@"));
        userList.add(new UserModel("foo bar13", "fooba@"));
        rankingService = new RankingService();
        ranking = rankingService.createRanking(userList);

    }

    @Test
    public void sumarPuntosALos20MejoresRankeados() {
        rankingService.rankearATodos(ranking);
        List<UserModel> usuarios = rankingService.getUsuariosEficiente(ranking);
        Stream<Integer> integerStream = usuarios.stream().map((usuario -> usuario.getPoints()));
        integerStream.forEach(point -> Assert.assertEquals(point.intValue(), 5000));
    }

}
