import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuFrame extends JFrame implements ActionListener {
    private JButton btnAddStudent, btnAddBook, btnBorrowBook;
    private ArrayList<Student> students;
    private ArrayList<Book> books;

    public MainMenuFrame() {
        students = new ArrayList<>();
        books = new ArrayList<>();

        setTitle("Main Menu");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        add(title);
        add(btnAddStudent);
        add(btnAddBook);
        add(btnBorrowBook);

        btnAddStudent.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnBorrowBook.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudent) {
            new AddStudentFrame(students).setVisible(true);
        } else if (e.getSource() == btnAddBook) {
            new AddBookFrame(books).setVisible(true);
        } else if (e.getSource() == btnBorrowBook) {
            new BorrowBookFrame(students, books).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MainMenuFrame().setVisible(true);
    }
}
