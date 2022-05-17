import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    @Before
    public void setup() {

    }

    @After
    public void cleanup() {

    }

    @Test
    public void add() {
        String[] args = {"fish", "chimpanzee", "platypus", "caterpillar", "dog", "panda", "woodchuck"};
        TreeSet<String> terms = new TreeSet<String>();
        for (String term : args) {
            terms = Main.getGlossaryTerms(terms, term);
        }
        Iterator<String> iterator = terms.iterator();
        String value = "";
        while (iterator.hasNext()) {
            value = iterator.next();
            if (value == "panda") {
                break;
            }
        }
        assertEquals("panda", value);
    }
}
