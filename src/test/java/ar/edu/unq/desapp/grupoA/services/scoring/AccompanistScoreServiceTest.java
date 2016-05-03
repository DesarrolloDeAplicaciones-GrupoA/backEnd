package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.ScoreRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AccompanistScoreServiceTest extends BaseScoreServiceTest<UserModel> {

    private UserModel scoringModel;

    @Autowired
    private AccompanistScoreService accompanistScoreService;

    @Override
    protected int getUserPoints() {
        return this.scoringModel.getPoints();
    }

    @Override
    protected UserModel getScoringModel() {
        return this.scoringModel;
    }

    @Override
    protected void createScoringModel() {
        this.scoringModel = this.getUser();
    }

    @Override
    protected Set<Score> getScoringModelScores() {
        return this.scoringModel.getAccompanistScores();
    }

    @Override
    protected BaseScoreService<UserModel> getService() {
        return this.accompanistScoreService;
    }

    @Test
    public void hasOneMoreDriverScoreInRepository() {
        assertEquals(0, this.scoreRepository.count());
        getService().createScore(this.getScoringModel(), travel, true);
        assertEquals(1, this.scoreRepository.count());
    }

}
