package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.VehicleTestFactory;

import java.util.List;

public class VehicleScoreServiceTest extends BaseScoreServiceTest<Vehicle> {

    protected UserModel driver;

    public void setUp() {
        this.driver = new UserModelTestFactory().getUser();
        super.setUp();
    }

    @Override
    protected int getUserPoints() {
        return this.scoringModel.getDriverPoints();
    }

    @Override
    protected void createScoringModel() {
        this.scoringModel = new VehicleTestFactory().getVehicle(this.driver);
    }

    @Override
    protected void createService() {
        this.service = new VehicleScoreService();
    }

    @Override
    protected List<Score> getScoringModelScores() {
        return this.scoringModel.getScores();
    }
}
