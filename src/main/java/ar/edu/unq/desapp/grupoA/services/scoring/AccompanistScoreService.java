package ar.edu.unq.desapp.grupoA.services.scoring;


import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.UserModel;

public class AccompanistScoreService extends BaseScoreService<UserModel> {

    @Override
    protected void markBadScoresAsApplied(UserModel user) {
        user.markBadScoresAsApplied();
    }

    @Override
    protected int badScoresCount(UserModel user) {
        return user.getAccompanistBadScores().size();
    }

    @Override
    protected UserModel getUserModel(UserModel accompanist) {
        return accompanist;
    }

    @Override
    protected void addScore(UserModel accompanist, Score score) {
        accompanist.addAccompanistScore(score);
    }
}
