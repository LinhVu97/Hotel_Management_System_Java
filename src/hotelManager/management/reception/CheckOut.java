package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {
    Choice choice;
    JTextField t1;
    JButton b1, b2, b3;

    public CheckOut() {
        setBounds(150, 100, 900, 400);
        setLayout(null);

        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(100, 20, 100, 30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l1);

        // Customer ID
        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30, 80, 100, 30);
        add(l2);

        choice = new Choice();
        try {
            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                choice.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        choice.setBounds(200, 80, 150, 30);
        add(choice);

        // Room Number
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 130, 100, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 130, 150, 30);
        add(t1);

        // Button
        b1 = new JButton("Check Out");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30, 200, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(170, 200, 120, 30);
        b2.addActionListener(this);
        add(b2);

        // Image
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image img = imgIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(img);
        b3 = new JButton(image);
        b3.setBounds(380, 80, 20, 20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label = new JLabel(i6);
        label.setBounds(450, 10, 400, 250);
        add(label);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String id = choice.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '" + id + "'";
            String str2 = "update rooms set available = 'Available' where roomn_number = '" + room + "'";
            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Check Out Done");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        } else if (e.getSource() == b3) {
            String id = choice.getSelectedItem();
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number = '" + id + "'");
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new CheckOut();
    }
}
