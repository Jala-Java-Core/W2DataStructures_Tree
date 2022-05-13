import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class TestMentee {
    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void compareEquals() {
        Mentee mentee1 = new Mentee(2, "Kathy");
        Mentee mentee2 = new Mentee(1, "Jane");
        Mentee mentee3 = new Mentee(3, "Eliana");
        Mentee mentee4 = new Mentee(5, "Yujie");
        Mentee mentee5 = new Mentee(4, "Swapneel");
        assertEquals(true, mentee1.compareTo(mentee2) != 0);
    }

    @Test
    public void compareMinor() {
        Mentee mentee1 = new Mentee(2, "Kathy");
        Mentee mentee2 = new Mentee(1, "Jane");
        Mentee mentee3 = new Mentee(3, "Eliana");
        Mentee mentee4 = new Mentee(5, "Yujie");
        Mentee mentee5 = new Mentee(4, "Swapneel");
        assertEquals(-1, mentee1.compareTo(mentee2));
    }

    @Test
    public void compareMajor() {
        Mentee mentee1 = new Mentee(2, "Kathy");
        Mentee mentee2 = new Mentee(1, "Jane");
        Mentee mentee3 = new Mentee(3, "Eliana");
        Mentee mentee4 = new Mentee(5, "Yujie");
        Mentee mentee5 = new Mentee(4, "Swapneel");
        assertEquals(1, mentee1.compareTo(mentee2));
    }

    @Test
    public void acceptMenteesIntoProgram() {
        Mentee mentee1 = new Mentee(2, "Kathy");
        Mentee mentee2 = new Mentee(1, "Jane");
        Mentee mentee3 = new Mentee(3, "Eliana");
        Mentee mentee4 = new Mentee(5, "Yujie");
        Mentee mentee5 = new Mentee(4, "Swapneel");
        PriorityQueue<Mentee> interestedMentees = new PriorityQueue<Mentee>();
        interestedMentees.add(mentee1);
        interestedMentees.add(mentee2);
        interestedMentees.add(mentee3);
        interestedMentees.add(mentee4);
        interestedMentees.add(mentee5);
        String[] menteesInProgram = {"Jane", "Kathy", "Eliana"};
        assertLinesMatch(Arrays.asList(menteesInProgram), Arrays.asList(Mentee.acceptMenteesIntoProgram(3, interestedMentees)));
    }
}
