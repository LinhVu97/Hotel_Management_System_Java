package hotelManager.admin;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    private JTextField t1, t2, t3, t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1, b2;
    Choice c1;

    public AddDriver() {
        setBounds(200, 50, 1000, 500);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setTitle("ADD DRIVER");

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image img = imageIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(img);
        JLabel l15 = new JLabel(image);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        // Label
        JLabel label = new JLabel("Add Drivers");
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        label.setBounds(194, 10, 120, 22);
        add(label);

        // Name
        JLabel name = new JLabel("Name");
        name.setForeground(new Color(25, 25, 112));
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setBounds(64, 70, 102, 22);
        add(name);

        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 22);
        add(t1);

        // Age
        JLabel age = new JLabel("Age");
        age.setForeground(new Color(25, 25, 112));
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        age.setBounds(64, 120, 102, 22);
        add(age);

        t2 = new JTextField();
        t2.setBounds(174, 120, 156, 22);
        add(t2);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setForeground(new Color(25, 25, 112));
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setBounds(64, 170, 102, 22);
        add(gender);

        comboBox = new JComboBox(new String[] { "Male", "Female" });
        comboBox.setBounds(176, 170, 154, 22);
        add(comboBox);

        // Car company
        JLabel carCompany = new JLabel("Car Company");
        carCompany.setForeground(new Color(25, 25, 112));
        carCompany.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompany.setBounds(64, 220, 102, 22);
        add(carCompany);

        t3 = new JTextField();
        t3.setBounds(174, 220, 156, 22);
        add(t3);

        // Car brand
        JLabel carBrand = new JLabel("Car Brand");
        carBrand.setForeground(new Color(25, 25, 112));
        carBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
        carBrand.setBounds(64, 270, 102, 22);
        add(carBrand);

        t4 = new JTextField();
        t4.setBounds(174, 270, 156, 22);
        add(t4);

        // Available
        JLabel available = new JLabel("Available");
        available.setForeground(new Color(25, 25, 112));
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        available.setBounds(64, 320, 102, 22);
        add(available);

        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
        comboBox_1.setBounds(176, 320, 154, 22);
        add(comboBox_1);

        // Location
        JLabel location = new JLabel("Location");
        location.setForeground(new Color(25, 25, 112));
        location.setFont(new Font("Tahoma", Font.BOLD, 14));
        location.setBounds(64, 370, 102, 22);
        add(location);

        t5 = new JTextField();
        t5.setBounds(174, 370, 156, 22);
        add(t5);

        // Button
        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 420, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 420, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                try {
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String) comboBox.getSelectedItem();
                    String company = t3.getText();
                    String brand = t4.getText();
                    String available = (String) comboBox_1.getSelectedItem();
                    String location = t5.getText();
                    String str = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','"
                            + company + "', '" + brand + "', '" + available + "','" + location + "')";

                    conn c = new conn();
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);

                } catch (Exception er) {
                    er.printStackTrace();
                }
            } else if (e.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new AddDriver();
    }

}
