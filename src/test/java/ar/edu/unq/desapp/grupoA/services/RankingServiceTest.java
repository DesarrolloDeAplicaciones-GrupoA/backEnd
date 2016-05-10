package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.models.Ranking;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.RankingRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class RankingServiceTest extends AbstractServiceTest {

    @Autowired
    private RankingService rankingService;
    @Autowired
    private UserModelTestFactory userModelTestFactory;
    @Autowired
    private RankingRepository rankingRepository;
    private Ranking ranking;

    @Before
    public void setUp() {
        HashSet<UserModel> userSet = new HashSet<>();
        userSet.add(this.getUser());
        userSet.add(this.getUser());
        userSet.add(this.getUser());
        this.ranking = this.rankingService.createRanking(userSet);
    }

    @Test
    public void sumarPuntosALos20MejoresRankeados() {
        this.rankingService.rankearATodos(this.ranking);
        Set<UserModel> usuarios = this.rankingService.getUsuariosEficiente(this.ranking);
        Stream<Integer> integerStream = usuarios.stream().map((usuario -> usuario.getPoints()));
        integerStream.forEach(point -> Assert.assertEquals(point.intValue(), 5000));
    }

    @Test
    public void hasOneMoreRanking() {
        Assert.assertEquals(1, this.rankingRepository.count());

    }

    private UserModel getUser() {
        return this.userModelTestFactory.getUser();
    }

}
