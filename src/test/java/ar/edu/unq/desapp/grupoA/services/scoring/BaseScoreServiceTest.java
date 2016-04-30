package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.services.AbstractServiceTest;
import ar.edu.unq.desapp.grupoA.testUtis.factories.TravelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public abstract class BaseScoreServiceTest<T extends ScoringModel> extends AbstractServiceTest {

    protected T scoringModel;
    protected Travel travel;
    protected BaseScoreService<T> service;

    @Autowired
    protected UserModelTestFactory userModelTestFactory;

    @Before
    public void setUp() {
        this.travel = new TravelTestFactory().getTravelTest();
        this.createScoringModel();
        this.createService();
    }

    @Test
    public void testCreateScore() {
        Score score = service.createScore(this.scoringModel, travel, true);
        assertTrue(score.isGood());
        assertEquals(score.getTravel(), travel);
    }

    @Test
    public void testUserOneMoreDriverScore() {
        service.createScore(this.scoringModel, travel, false);
        assertEquals(this.getScoringModelScores().size(), 1);
    }

    @Test
    public void testAddPointForGoodReputation() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, true);
        assertEquals(pointsBefore + 500, this.getUserPoints());
    }

    @Test
    public void testDoNotSubtractPointsOnOneBadScore() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, false);
        assertEquals(pointsBefore, this.getUserPoints());
    }

    @Test
    public void testSubtractPointsOnTwoBadScore() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, false);
        service.createScore(this.scoringModel, travel, false);
        assertEquals(pointsBefore - 1000, this.getUserPoints());
    }

    @Test
    public void testDoNotSubtractPointsOnThreeBadScore() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, false);
        service.createScore(this.scoringModel, travel, false);
        service.createScore(this.scoringModel, travel, false);
        assertEquals(pointsBefore - 1000, this.getUserPoints());
    }

    protected abstract int getUserPoints();


    protected abstract void createScoringModel();

    protected abstract void createService();

    protected abstract Set<Score> getScoringModelScores();
}
