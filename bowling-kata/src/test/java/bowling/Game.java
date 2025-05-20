package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Frame> frames = new ArrayList<>();

    public Game() {
        frames.add(new Frame());
    }

    public void roll(int i) {
        Frame previous = frames.getLast();
        if (previous.isFinish()) {
            if (previous.isSpare() || previous.isStrike()) {
                previous.addBonus(i);
                if (previous.isStrike() && frames.size()>1 && frames.get(frames.size()-2).isStrike())
                {
                    frames.get(frames.size()-2).addBonus(i);
                }
            }
                frames.add(new Frame());
        }
        else if (frames.size()>1 && frames.get(frames.size()-2).isStrike())
        {
            previous = frames.get(frames.size()-2);
            previous.addBonus(i);
        }

        Frame current = frames.getLast();
        current.roll(i);
    }

    public int score() {
        int score = frames.stream().mapToInt(Frame::score).sum();
        return score;
    }
}
