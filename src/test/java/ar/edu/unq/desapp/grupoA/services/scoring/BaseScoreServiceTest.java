package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.services.AbstractServiceTest;
import ar.edu.unq.desapp.grupoA.testUtis.factories.TravelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public abstract class BaseScoreServiceTest<T extends ScoringModel> extends AbstractServiceTest {

    protected Travel travel;

    @Autowired
    protected UserModelTestFactory userModelTestFactory;

    @Before
    public void setUp() {
        this.travel = new TravelTestFactory().getTravelTest();
        this.createScoringModel();
//        this.createService();
    }

    @Test
    public void testCreateScore() {
        Score score = getService().createScore(this.getScoringModel(), travel, true);
        assertTrue(score.isGood());
        assertEquals(score.getTravel(), travel);
    }

    @Test
    public void testUserOneMoreDriverScore() {
        getService().createScore(this.getScoringModel(), travel, false);
        assertEquals(this.getScoringModelScores().size(), 1);
    }

    @Test
    public void testAddPointForGoodReputation() {
        int pointsBefore = this.getUserPoints();
        getService().createScore(this.getScoringModel(), travel, true);
        assertEquals(pointsBefore + 500, this.getUserPoints());
    }

    @Test
    public void testDoNotSubtractPointsOnOneBadScore() {
        int pointsBefore = this.getUserPoints();
        getService().createScore(this.getScoringModel(), travel, false);
        assertEquals(pointsBefore, this.getUserPoints());
    }

    @Test
    public void testSubtractPointsOnTwoBadScore() {
        int pointsBefore = this.getUserPoints();
        getService().createScore(this.getScoringModel(), travel, false);
        getService().createScore(this.getScoringModel(), travel, false);
        assertEquals(pointsBefore - 1000, this.getUserPoints());
    }

    @Test
    public void testDoNotSubtractPointsOnThreeBadScore() {
        int pointsBefore = this.getUserPoints();
        getService().createScore(this.getScoringModel(), travel, false);
        getService().createScore(this.getScoringModel(), travel, false);
        getService().createScore(this.getScoringModel(), travel, false);
        assertEquals(pointsBefore - 1000, this.getUserPoints());
    }

    protected abstract int getUserPoints();

    protected abstract T getScoringModel();

    protected abstract void createScoringModel();

    protected abstract Set<Score> getScoringModelScores();

    protected abstract BaseScoreService<T> getService();
}
