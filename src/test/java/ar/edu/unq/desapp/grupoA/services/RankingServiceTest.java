package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class RankingServiceTest {

    private RankingService rankingService;
    private Ranking ranking;

    @Before
    public void setUp() {
        HashSet<UserModel> userSet = new HashSet<>();
        userSet.add(new UserModel("foo bar", "fooba@@@"));
        userSet.add(new UserModel("foo bar12", "fooba@@"));
        userSet.add(new UserModel("foo bar13", "fooba@"));
        rankingService = new RankingService();
        ranking = rankingService.createRanking(userSet);

    }

    @Test
    public void sumarPuntosALos20MejoresRankeados() {
        rankingService.rankearATodos(ranking);
        Set<UserModel> usuarios = rankingService.getUsuariosEficiente(ranking);
        Stream<Integer> integerStream = usuarios.stream().map((usuario -> usuario.getPoints()));
        integerStream.forEach(point -> Assert.assertEquals(point.intValue(), 5000));
    }

}
