package ar.edu.unq.desapp.grupoA.services.scoring;


import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.testUtis.factories.TravelTestFactory;
import junit.framework.TestCase;

import java.util.List;

public abstract class BaseScoreServiceTest<T extends ScoringModel> extends TestCase {

    protected T scoringModel;
    protected Travel travel;
    protected BaseScoreService<T> service;

    public void setUp() {
        this.travel = new TravelTestFactory().getTravelTest();
        this.createScoringModel();
        this.createService();
    }

    public void testCreateScore() {
        Score score = service.createScore(this.scoringModel, travel, true);
        assertTrue(score.isGood());
        assertEquals(score.getTravel(), travel);
    }

    public void testUserOneMoreDriverScore() {
        service.createScore(this.scoringModel, travel, false);
        assertEquals(this.getScoringModelScores().size(), 1);
    }

    public void testAddPointForGoodReputation() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, true);
        assertEquals(pointsBefore + 500, this.getUserPoints());
    }

    public void testDoNotSubtractPointsOnOneBadScore() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, false);
        assertEquals(pointsBefore, this.getUserPoints());
    }

    public void testSubtractPointsOnTwoBadScore() {
        int pointsBefore = this.getUserPoints();
        service.createScore(this.scoringModel, travel, false);
        service.createScore(this.scoringModel, travel, false);
        assertEquals(pointsBefore - 1000, this.getUserPoints());
    }

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

    protected abstract List<Score> getScoringModelScores();
}
