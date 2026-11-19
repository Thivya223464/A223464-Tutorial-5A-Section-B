import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddStudentFrame extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea areaStudents;
    private ArrayList<Student> students;

    public AddStudentFrame(ArrayList<Student> studentList) {
        students = studentList;
        setTitle("Add Student Info");
        setSize(450, 260);
        setLayout(new FlowLayout());

        txtName = new JTextField(20);
        txtMatric = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaStudents = new JTextArea(6, 35);
        areaStudents.setEditable(false);

        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Matric:"));
        add(txtMatric);
        add(btnAdd);
        add(btnList);
        add(new JLabel("Students:"));
        add(new JScrollPane(areaStudents));

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                students.add(new Student(name, matric));
                txtName.setText("");
                txtMatric.setText("");
            }
        } else if (e.getSource() == btnList) {
            StringBuilder sb = new StringBuilder();
            for (Student s : students) {
                sb.append("Name : ").append(s.getName())
                  .append(" (").append(s.getMatric()).append(")\n");
            }
            areaStudents.setText(sb.toString());
        }
    }
}
