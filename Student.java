public class Student {
    private String name;
    private String matric;
    private Book borrowedBook;

    public Student(String studentName, String studentMatric) {
        name = studentName;
        matric = studentMatric;
        borrowedBook = null;
    }

    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public void borrowBy(Book book) {
        borrowedBook = book;
    }

    @Override
    public String toString() {
        return name + " (" + matric + ")";
    }
}
