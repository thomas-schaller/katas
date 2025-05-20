package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Frame> frames = new ArrayList<>();
    public Game()
    {
        frames.add( new Frame());
    }
    public void roll(int i) {
        Frame previous = frames.getLast();
        if (previous.isFinish() )
        {
            frames.add(new Frame());
            if ( previous.isSpare() )
            {
                previous.setBonus(i);
            }
        }
        Frame current = frames.getLast();
        current.roll(i);
    }

    public int score() {
        int score = frames.stream().mapToInt(Frame::score).sum();
        return score;
    }
}
