package hotelManager.admin;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
    JComboBox c1;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 50, 990, 550);
        getContentPane().setLayout(null);

        // Name
        JLabel Name = new JLabel("NAME");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 30, 150, 27);
        add(Name);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        // Age
        JLabel Age = new JLabel("AGE");
        Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Age.setBounds(60, 80, 150, 27);
        add(Age);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        // Gender
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        JRadioButton Male = new JRadioButton("MALE");
        Male.setBackground(Color.WHITE);
        Male.setBounds(200, 120, 70, 27);
        add(Male);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 70, 27);
        add(Female);

        // Job
        JLabel Job = new JLabel("JOB");
        Job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Job.setBounds(60, 170, 150, 27);
        add(Job);

        String course[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service",
                "Waiter/Waitress", "Manager", "Accountant", "Chef" };
        c1 = new JComboBox(course);
        c1.setBackground(Color.white);
        c1.setBounds(200, 170, 150, 30);
        add(c1);

        // Salary
        JLabel Salary = new JLabel("SALARY");
        Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Salary.setBounds(60, 220, 150, 27);
        add(Salary);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        // Phone
        JLabel Phone = new JLabel("PHONE");
        Phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phone.setBounds(60, 270, 150, 27);
        add(Phone);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        // Address
        JLabel Address = new JLabel("ADDRESS");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 320, 150, 27);
        add(Address);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);

        // Email
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        // Button Save
        JButton Save = new JButton("SAVE");
        Save.setBounds(200, 420, 150, 30);
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.WHITE);
        add(Save);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        // Action
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String age = textField_1.getText();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String address = textField_5.getText();
                String email = textField_6.getText();

                String gender = null;

                if (Male.isSelected()) {
                    gender = "male";
                } else if (Female.isSelected()) {
                    gender = "female";
                }

                String job = (String) c1.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + job
                            + "', '" + salary + "', '" + phone + "','" + address + "', '" + email + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
