package ar.edu.unq.desapp.grupoA.models;

public class Score {

    private Travel travel;
    private boolean isGood;
    private boolean applied;

    public Score(Travel travel, boolean isGood) {
        this.travel = travel;
        this.isGood = isGood;
        this.applied = false;
    }

    public boolean isGood() {
        return isGood;
    }

    public Travel getTravel() {
        return travel;
    }

    public void applied() {
        this.applied = true;
    }
}
