import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookFrame extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea areaBooks;
    private ArrayList<Book> books;

    public AddBookFrame(ArrayList<Book> bookList) {
        books = bookList;
        setTitle("Add Book Info");
        setSize(450, 260);
        setLayout(new FlowLayout());

        txtTitle = new JTextField(20);
        txtAuthor = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaBooks = new JTextArea(6, 35);
        areaBooks.setEditable(false);

        add(new JLabel("Book Title:"));
        add(txtTitle);
        add(new JLabel("Author:"));
        add(txtAuthor);
        add(btnAdd);
        add(btnList);
        add(new JLabel("Books:"));
        add(new JScrollPane(areaBooks));

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                books.add(new Book(title, author));
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        } else if (e.getSource() == btnList) {
            StringBuilder sb = new StringBuilder();
            for (Book b : books) {
                sb.append("Book title : ").append(b.getTitle())
                  .append(" (Author : ").append(b.getAuthor()).append(")\n");
            }
            areaBooks.setText(sb.toString());
        }
    }
}
