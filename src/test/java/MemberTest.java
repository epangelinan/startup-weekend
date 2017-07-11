import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class MemberTest {

  @Before
  public void tearDown() {
    Member.clear();
  }

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Anthony");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Anthony");
    assertEquals("Anthony", myMember.getName());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Member myMember = new Member("Anthony");
    assertEquals(false, myMember.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Member myMember = new Member("Anthony");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myMember.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Anthony");
    Member secondMember = new Member("Henry");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clear_emptiesAllMembersFromArrayList_0() {
    Member myMember = new Member("Anthony");
    Member.clear();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_membersInstantiateWithAnID_1() {
    Member.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
    Member myMember = new Member("Anthony");
    assertEquals(1, myMember.getId());
  }

  @Test
  public void find_returnsMemberWithSameId_secondMember() {
    Member firstMember = new Member("Anthony");
    Member secondMember = new Member("Henry");
    assertEquals(Member.find(secondMember.getId()), secondMember);
  }
}
