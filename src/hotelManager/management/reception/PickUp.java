package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PickUp extends JFrame implements ActionListener {
    Choice choice;
    JButton b1, b2;
    JTable table;

    public PickUp() {
        JLabel label = new JLabel("Pick Up Service");
        label.setBounds(300, 30, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label);

        // Type of car
        JLabel l1 = new JLabel("Type Of Car");
        l1.setBounds(50, 100, 100, 22);
        add(l1);

        choice = new Choice();
        try {
            conn c = new conn();
            String str = "select * from driver";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                choice.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        choice.setBounds(150, 100, 200, 25);
        add(choice);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        // Button
        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300, 520, 120, 30);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(500, 520, 120, 30);
        add(b2);

        // Name
        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 160, 100, 22);
        add(l2);

        // Age
        JLabel l3 = new JLabel("Age");
        l3.setBounds(190, 160, 100, 22);
        add(l3);

        // Gender
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(330, 160, 100, 22);
        add(l4);

        // Company
        JLabel l5 = new JLabel("Company");
        l5.setBounds(460, 160, 100, 22);
        add(l5);

        // Brand
        JLabel l6 = new JLabel(" Brand");
        l6.setBounds(630, 160, 100, 22);
        add(l6);

        // Availability
        JLabel l7 = new JLabel(" Availability");
        l7.setBounds(750, 160, 100, 22);
        add(l7);

        // Location
        JLabel l8 = new JLabel(" Location");
        l8.setBounds(900, 160, 100, 22);
        add(l8);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(150, 100, 1000, 650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String s1 = (String) choice.getSelectedItem();
                String str = "select * from driver where brand = '" + s1 + "'";

                ResultSet rs = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new PickUp();
    }
}
