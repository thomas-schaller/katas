import bowling.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

   @Test
   public void scoreOneRollWithoutBonus()
   {
      Game g = new Game();
      int firstRoll =3;
      int secondRoll=4;
      g.roll(firstRoll);
      g.roll(secondRoll);
      Assert.assertEquals(firstRoll+secondRoll,g.score());
   }


   }
