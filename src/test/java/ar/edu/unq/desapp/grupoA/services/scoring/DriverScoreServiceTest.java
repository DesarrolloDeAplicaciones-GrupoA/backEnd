package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;

import java.util.List;

public class DriverScoreServiceTest extends BaseScoreServiceTest<UserModel> {

    @Override
    protected int getUserPoints() {
        return this.scoringModel.getPoints();
    }

    @Override
    protected void createScoringModel() {
        this.scoringModel = new UserModelTestFactory().getUser();
    }

    @Override
    protected void createService() {
        this.service = new DriverScoreService();
    }

    @Override
    protected List<Score> getScoringModelScores() {
        return this.scoringModel.getDriverScores();
    }
}
