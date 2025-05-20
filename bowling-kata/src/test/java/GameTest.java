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

   @Test
   public void score2Frame()
   {
      Game g = new Game();
      int firstRoll =3;
      int secondRoll=7;
      int thirdRoll=2;
      int forthRoll=1;
      g.roll(firstRoll);
      g.roll(secondRoll);
      g.roll(thirdRoll);
      g.roll(forthRoll);
      Assert.assertEquals(firstRoll+secondRoll+thirdRoll+thirdRoll+forthRoll,g.score());
   }

   }
