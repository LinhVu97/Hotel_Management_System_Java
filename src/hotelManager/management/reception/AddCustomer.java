package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel label, l1, l2, l3, l4, l5, l6, l7, l8;
    JButton b1, b2;
    JTextField t1, t2, t3, t4, t5;
    JComboBox comboBox;
    Choice c1;
    JRadioButton r1, r2;

    public AddCustomer() {
        setBounds(150, 100, 900, 500);
        setLayout(null);

        label = new JLabel("NEW CUSTOMER FORM");
        label.setBounds(250, 30, 300, 30);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label);

        // ID
        l1 = new JLabel("ID");
        l1.setBounds(35, 90, 100, 20);
        add(l1);

        comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
        comboBox.setBackground(Color.white);
        comboBox.setBounds(271, 90, 150, 20);
        add(comboBox);

        // Number
        l2 = new JLabel("Number");
        l2.setBounds(35, 130, 100, 22);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 130, 150, 22);
        add(t1);

        // Name
        l3 = new JLabel("Name");
        l3.setBounds(35, 170, 100, 22);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(271, 170, 150, 22);
        add(t2);

        // Gender
        l4 = new JLabel("Gender");
        l4.setBounds(35, 210, 100, 22);
        add(l4);

        r1 = new JRadioButton("Male");
        r1.setBounds(271, 210, 80, 22);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(360, 210, 80, 22);
        r2.setBackground(Color.white);
        add(r2);

        // Country
        l5 = new JLabel("Country");
        l5.setBounds(35, 250, 100, 22);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(271, 250, 150, 22);
        add(t3);

        // Allocated room number
        l6 = new JLabel("Allocated Room Number");
        l6.setBounds(35, 290, 200, 22);
        add(l6);

        c1 = new Choice();
        try {
            conn c = new conn();
            String str = "Select * from rooms";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                c1.add(rs.getString("roomn_number"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        c1.setBounds(271, 290, 150, 22);
        add(c1);

        // Checked In
        l7 = new JLabel("Checked In");
        l7.setBounds(35, 330, 100, 22);
        add(l7);

        t4 = new JTextField();
        t4.setBounds(271, 330, 150, 22);
        add(t4);

        // Deposit
        l8 = new JLabel("Deposit");
        l8.setBounds(35, 370, 100, 22);
        add(l8);

        t5 = new JTextField();
        t5.setBounds(271, 370, 150, 22);
        add(t5);

        // Button
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(50, 410, 120, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200, 410, 120, 25);
        b2.addActionListener(this);
        add(b2);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(520, 10, 300, 500);
        add(l1);

        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String id = (String) comboBox.getSelectedItem();
                String number = t1.getText();
                String name = t2.getText();
                String gender = null;

                if (r1.isSelected()) {
                    gender = "Male";
                } else if (r2.isSelected()) {
                    gender = "Female";
                }
                ;

                String country = t3.getText();
                String room = c1.getSelectedItem();
                String status = t4.getText();
                String deposit = t5.getText();

                String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender
                        + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";
                String str1 = "update rooms set available = 'Occupied' where roomn_number = '" + room + "'";

                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Customer Add Successfully");
                setVisible(false);

            } catch (Exception er) {
                er.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new AddCustomer();
    }

}
