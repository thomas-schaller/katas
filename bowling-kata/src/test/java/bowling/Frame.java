package bowling;

public class Frame {
    int nbRoll = 0;
    int nbPin = 0;
    int bonus = 0;

    public void roll(int nbPin) {
        this.nbPin += nbPin;
        nbRoll++;
    }

    public boolean isFinish() {
        return nbRoll >= 2 || nbPin >= 10;
    }

    public void addBonus(int bonusValue) {
        bonus += bonusValue;
    }

    public int score() {
        return nbPin + bonus;
    }

    public boolean isSpare() {
        return nbPin == 10 && nbRoll == 2;
    }
    public boolean isStrike() {
        return nbPin == 10 && nbRoll == 1;
    }
}
