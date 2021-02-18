package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoom extends JFrame implements ActionListener {
    JLabel label, l1, l2, l3, l4;
    Choice choice;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

    public UpdateRoom() {
        setBounds(250, 100, 1000, 500);
        setLayout(null);

        label = new JLabel("Update Room Status");
        label.setBounds(100, 30, 300, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label);

        // Guest ID
        l1 = new JLabel("Guest ID");
        l1.setBounds(30, 100, 120, 22);
        add(l1);

        choice = new Choice();
        try {
            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                choice.add(rs.getString("number"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        choice.setBounds(250, 100, 120, 22);
        add(choice);

        // Room Number
        l2 = new JLabel("Room Number");
        l2.setBounds(30, 150, 120, 22);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(250, 150, 120, 22);
        add(t1);

        // Availability
        l3 = new JLabel("Availability");
        l3.setBounds(30, 200, 120, 22);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(250, 200, 120, 22);
        add(t2);

        // Clean Status
        label = new JLabel("Clean Status");
        label.setBounds(30, 250, 120, 22);
        add(label);

        t3 = new JTextField();
        t3.setBounds(250, 250, 120, 22);
        add(t3);

        // Button
        b1 = new JButton("Check");
        b1.addActionListener(this);
        b1.setBounds(120, 300, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Update");
        b2.addActionListener(this);
        b2.setBounds(50, 350, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setBounds(200, 350, 120, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(400, 80, 600, 250);
        add(image);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String room = null;
            String s1 = choice.getSelectedItem();
            String str = "select * from customer where number = '" + s1 + "'";

            try {
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    room = rs.getString("room");
                    t1.setText(rs.getString("room"));
                }

                String str2 = "select * from rooms where roomn_number = '" + room + "'";
                ResultSet rs2 = c.s.executeQuery(str2);
                while (rs2.next()) {
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            try {
                conn c = new conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update rooms set available = '" + available + "', status = '" + status
                        + "' where roomn_number = '" + room + "'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                setVisible(false);
            } catch (Exception e2) {
            }
        } else if (e.getSource() == b3) {
            setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new UpdateRoom();
    }
}
