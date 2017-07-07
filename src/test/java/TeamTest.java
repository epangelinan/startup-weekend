import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team myTeam = new Team("Seattle");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void Team_instantiatesWithName_String() {
    Team myTeam = new Team("Seattle");
    assertEquals("Seattle", myTeam.getName());
  }

}
