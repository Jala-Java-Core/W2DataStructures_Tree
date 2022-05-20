import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    // Code W2-6
    // Example: glossary of terms
    public static TreeSet<String> getGlossaryTerms(TreeSet<String> glossaryTerms, String manuscript) {
        String[] tokens = getWordTokens(manuscript);
        if (glossaryTerms.isEmpty()) {
            glossaryTerms = new TreeSet<String>();
        }
        for (String token : tokens) {
            glossaryTerms.add(token);
        }
        return glossaryTerms;
    }

    // Code W2-6
    public static String[] getWordTokens(String manuscript) {
       String[] tokens = new String[1];
       tokens[0] = (manuscript);
       return tokens;
    }

    public static void main(String @NotNull [] args) {



        //Code W2-7
        BookReport chris = new BookReport("The Cathedral and the Bazaar", "Chris", 50);
        BookReport ada = new BookReport("The Idea Factory", "Ada", 2);
        BookReport toby = new BookReport("Toby tries a Taco", "Toby", 100);
        BookReport pooh = new BookReport("The Secret Life of Bees", "Pooh", 2);

        TreeMap<BookReport, Integer> reportScores = new TreeMap<BookReport, Integer>();
        reportScores.put(chris, 87);
        reportScores.put(ada, 30);
        reportScores.put(toby, 30);
        reportScores.put(pooh, 70);

        // Code W2-7
        for (Map.Entry<BookReport, Integer> entry : reportScores.entrySet()) {
            BookReport reportInfo = entry.getKey();
            int score = entry.getValue();
            System.out.println(reportInfo + " " + score + " pts.");
            System.out.println(reportInfo.toString());
        }
    }
}
