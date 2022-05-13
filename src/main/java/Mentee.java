import java.util.PriorityQueue;

public class Mentee implements Comparable<Mentee>{
    // Code W2-11
    protected int year;
    protected String name;

    public Mentee(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public int compareTo(Mentee otherMentee) {
        return year - otherMentee.year;
    }

    //Code W2-12
    // Add mentees into programs according to available mentors for programs.
    public static String[] acceptMenteesIntoProgram(int numMentorsAvailable, PriorityQueue<Mentee> interestedMentees) {
        int numToAccept = Math.min(interestedMentees.size(), numMentorsAvailable);
        String[] menteesInProgram = new String[numToAccept];
        for (int i = 0; i < numToAccept; i++) {
            Mentee mentee = interestedMentees.remove();
            menteesInProgram[i] = mentee.name;
        }
        return menteesInProgram;
    }
}
