public class BookReport implements Comparable<BookReport>{
    // Code W2-7
    protected String bookTitle;
    protected String studentName;
    protected int numPages;

    public BookReport(String bookTitle, String studentName, int numPages) {
        this.bookTitle = bookTitle;
        this.studentName = studentName;
        this.numPages = numPages;
    }

    public String toString() {
        return (studentName + " wrote" + numPages + " pages on " + bookTitle + ".");
    }

    @Override
    public int compareTo(BookReport otherBookReport) {
        return numPages - otherBookReport.numPages;
    }
}
