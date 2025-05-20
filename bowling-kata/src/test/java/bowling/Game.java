package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Frame> frames = new ArrayList<>();
    List<Frame> bonusOnce = new ArrayList<>();
    List<Frame> bonusTwice = new ArrayList<>();

    public Game() {
        frames.add(new Frame());
    }

    public void roll(int i) {
        managePreviousBonus(i);
        if (frames.getLast().isFinish()) {
            frames.add(new Frame());
        }
        Frame current = frames.getLast();
        current.roll(i);
        if (current.isSpare()) {
            bonusOnce.add(current);
        }
        if (current.isStrike()) {
            bonusTwice.add(current);
        }
    }

    private void managePreviousBonus(int nbPin) {
        bonusOnce.forEach(frame -> {
            frame.addBonus(nbPin);
        });
        bonusOnce = bonusTwice;
        bonusTwice.forEach(frame -> {
            frame.addBonus(nbPin);
        });
        bonusTwice= new ArrayList<>();
    }

    public int score() {
        int score = frames.stream().mapToInt(Frame::score).sum();
        return score;
    }
}
