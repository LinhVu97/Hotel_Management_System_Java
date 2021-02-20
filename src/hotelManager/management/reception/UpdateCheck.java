package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5;
    Choice choice;

    public UpdateCheck() {
        setBounds(150, 100, 1000, 500);
        setLayout(null);

        JLabel label = new JLabel("Check-in Detail");
        label.setBounds(150, 30, 300, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(label);

        // Customer ID
        JLabel l1 = new JLabel("Customer-ID");
        l1.setBounds(30, 80, 150, 22);
        add(l1);

        choice = new Choice();
        try {
            conn c = new conn();
            String str = "Select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                choice.add(rs.getString("number"));
            }

        } catch (Exception e) {

        }
        choice.setBounds(200, 80, 150, 22);
        add(choice);

        // Room Number
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(30, 120, 150, 22);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(200, 120, 150, 22);
        add(t1);

        // Name
        JLabel l3 = new JLabel("Name");
        l3.setBounds(30, 160, 150, 22);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(200, 160, 150, 22);
        add(t2);

        // Check-in
        JLabel l4 = new JLabel("Check-in");
        l4.setBounds(30, 200, 150, 22);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 22);
        add(t3);

        // Amount Paid
        JLabel l5 = new JLabel("Amount Paid");
        l5.setBounds(30, 240, 150, 22);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(200, 240, 150, 22);
        add(t4);

        // Pending Amount
        JLabel l6 = new JLabel("Pending Amount");
        l6.setBounds(30, 280, 150, 22);
        add(l6);

        t5 = new JTextField();
        t5.setBounds(200, 280, 150, 22);
        add(t5);

        // Button
        b1 = new JButton("Check");
        b1.addActionListener(this);
        b1.setBounds(120, 350, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Update");
        b2.addActionListener(this);
        b2.setBounds(50, 400, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setBounds(200, 400, 120, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        // Image
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(imgIcon);
        image.setBounds(450, 70, 476, 270);
        add(image);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String room = null;
            String deposit = null;
            String price = null;
            int amountPaid;
            String s1 = choice.getSelectedItem();
            String str = "select * from customer where number = '" + s1 + "' ";

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);

                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }

                String str1 = "select * from rooms where roomn_number ='" + room + "'";
                ResultSet rs1 = c.s.executeQuery(str1);
                while (rs1.next()) {
                    price = rs1.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == b2) {
            try {
                conn c = new conn();

                String s1 = choice.getSelectedItem();
                String s2 = t1.getText(); // room_number;
                String s3 = t2.getText(); // name
                String s4 = t3.getText(); // status;
                String s5 = t4.getText(); // deposit

                c.s.executeUpdate("update customer set room = '" + s2 + "', name = '" + s3 + "', status = '" + s4
                        + "', deposit = '" + s5 + "' where number = '" + s1 + "'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
            } catch (Exception ee) {
                System.out.println(ee);
            }
        } else if (e.getSource() == b3) {
            setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new UpdateCheck();
    }
}
