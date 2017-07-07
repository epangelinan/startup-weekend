import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void team_instantiatesCorrectly_true() {
    Team testTeam = new Team("Guam");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void getName_categoryInstantiatesWithName_Home() {
    Team testTeam = new Team("Guam");
    assertEquals("Guam", testTeam.getName());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true() {
    Team firstTeam = new Team("Guam");
    Team secondTeam = new Team("Seattle");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clear_emptiesAllTeamsFromList_0() {
    Team testTeam = new Team("Guam");
    Team.clear();
    assertEquals(Team.all().size(), 0);
  }

  @Test
  public void getId_teamsInstantiateWithAnId_1() {
    Team testTeam = new Team("Hawaii");
    assertEquals(1, testTeam.getId());
  }

  @Test
  public void find_returnsTeamWithSameId_secondCategory() {
    Team.clear();
    Team firstTeam = new Team("Guam");
    Team secondTeam = new Team("Seattle");
    assertEquals(Team.find(secondTeam.getId()), secondTeam);
  }

  @Test
  public void getMembers_initiallyReturnsEmptyList_ArrayList() {
    Team.clear();
    Team testTeam = new Team("Guam");
    assertEquals(0, testTeam.getMembers().size());
  }

  @Test
  public void addMember_addsMemberToList_true() {
    Team testTeam = new Team("Guam");
    Member testMember = new Member("Anthony");
    testTeam.addMember(testMember);
    assertTrue(testTeam.getMembers().contains(testMember));
  }
}
