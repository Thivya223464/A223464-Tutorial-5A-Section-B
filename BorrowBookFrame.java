import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BorrowBookFrame extends JFrame implements ActionListener {
    private JComboBox<Student> cmbStudents;
    private JComboBox<Book> cmbBooks;
    private JButton btnBorrow;
    private JLabel lblInfo;

    public BorrowBookFrame(ArrayList<Student> students, ArrayList<Book> books) {
        setTitle("Borrow Book");
        setSize(480, 260);
        setLayout(new FlowLayout());

        cmbStudents = new JComboBox<>(students.toArray(new Student[0]));
        cmbBooks = new JComboBox<>(books.toArray(new Book[0]));
        btnBorrow = new JButton("Borrow");
        lblInfo = new JLabel("Borrow Information :");

        add(new JLabel("Student Name & Matric:"));
        add(cmbStudents);
        add(new JLabel("Book Title & Author:"));
        add(cmbBooks);
        add(btnBorrow);
        add(lblInfo);

        btnBorrow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Student selectedStudent = (Student) cmbStudents.getSelectedItem();
        Book selectedBook = (Book) cmbBooks.getSelectedItem();
        if (selectedStudent != null && selectedBook != null) {
            selectedStudent.borrowBy(selectedBook);
            lblInfo.setText("Borrow Information : " + selectedStudent.getName()
                + " with matric number " + selectedStudent.getMatric()
                + " has borrow a book with title " + selectedBook.getTitle() + ".");
        }
    }
}
