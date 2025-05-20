import bowling.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

   @Test
   public void scoreOneRollWithoutBonus()
   {
      Game g = new Game();
      g.roll(3);
      g.roll(4);
      Assert.assertEquals(3+4,g.score());
   }
   }
