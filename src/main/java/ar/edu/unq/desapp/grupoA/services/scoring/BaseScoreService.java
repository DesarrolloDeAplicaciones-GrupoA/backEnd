package ar.edu.unq.desapp.grupoA.services.scoring;


import ar.edu.unq.desapp.grupoA.models.Score;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;

public abstract class BaseScoreService<T extends ScoringModel> {

    public Score createScore(T scoring, Travel travel, boolean isGood) {
        Score score = this.getScore(travel, isGood);
        this.addScore(scoring, score);
        this.applyScore(scoring, score);
        return score;
    }

    private void applyScore(T scoring, Score score) {
        if (score.isGood()) {
            this.applyGoodScore(scoring, score);
            this.markScoreAsApplied(score);
        } else if (this.badScoresCount(scoring) == 2) {
            this.applyBadScore(scoring, score);
            this.markBadScoresAsApplied(scoring);
        }
    }

    private void markScoreAsApplied(Score score) {
        score.applied();
    }

    protected abstract void markBadScoresAsApplied(T scoring);

    private void applyBadScore(T scoring, Score score) {
        UserModel user = this.getUserModel(scoring);
        user.removePoints(1000);
    }

    private void applyGoodScore(T scoring, Score score) {
        UserModel user = this.getUserModel(scoring);
        user.addPoints(500);
    }

    protected abstract int badScoresCount(T scoring);

    protected abstract UserModel getUserModel(T scoring);

    protected abstract void addScore(T scoringModel, Score score);

    protected Score getScore(Travel travel, boolean isGood) {
        return new Score(travel, isGood);
    }

}
