package ar.edu.unq.desapp.grupoA.services.scoring;


import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.Vehicle;

public class VehicleScoreService extends BaseScoreService<Vehicle> {

    @Override
    protected void markBadScoresAsApplied(Vehicle vehicle) {
        vehicle.markBadScoresAsApplied();
    }

    @Override
    protected int badScoresCount(Vehicle vehicle) {
        return vehicle.getBadScores().size();
    }

    @Override
    protected UserModel getUserModel(Vehicle vehicle) {
        return vehicle.getDriver();
    }

    @Override
    protected void addScore(Vehicle vehicle, Score score) {
        vehicle.addVehicleScore(score);
    }
}
