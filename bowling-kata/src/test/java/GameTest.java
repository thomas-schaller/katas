import bowling.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GameTest {


    @Test
    public void scoreDoubleStrike() {
        Game g = new Game();
        int [] rolls = {10,10,5,1,4,6,3,2,10,4,2,5,3,1,2,8,1};
        Arrays.stream(rolls).forEach(g::roll);
        Assert.assertEquals(Arrays.stream(rolls).sum()+10+5+5+1+3+4+2, g.score());
    }

}
