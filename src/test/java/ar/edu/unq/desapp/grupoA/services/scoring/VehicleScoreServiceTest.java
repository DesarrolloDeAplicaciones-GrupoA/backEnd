package ar.edu.unq.desapp.grupoA.services.scoring;

import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.testUtis.factories.VehicleTestFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class VehicleScoreServiceTest extends BaseScoreServiceTest<Vehicle> {

    @Autowired
    private VehicleTestFactory vehicleTestFactory;

    private Vehicle scoringModel;
    @Autowired
    private VehicleScoreService vehicleScoreService;

    @Override
    protected int getUserPoints() {
        return this.scoringModel.getDriverPoints();
    }

    @Override
    protected Vehicle getScoringModel() {
        return this.scoringModel;
    }

    @Override
    protected void createScoringModel() {
        this.scoringModel = vehicleTestFactory.getVehicle(this.getUser());
    }

    @Override
    protected Set<Score> getScoringModelScores() {
        return this.scoringModel.getScores();
    }

    @Override
    protected BaseScoreService<Vehicle> getService() {
        return this.vehicleScoreService;
    }


    @Test
    public void hasOneMoreDriverScoreInRepository() {
        assertEquals(0, this.scoreRepository.count());
        getService().createScore(this.getScoringModel(), travel, true);
        assertEquals(1, this.scoreRepository.count());
    }
}
