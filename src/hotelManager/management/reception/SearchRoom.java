package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JComboBox comboBox;
    JCheckBox checkBox;
    JButton b1, b2;
    JTable table;

    public SearchRoom() {
        JLabel label = new JLabel("Search Room");
        label.setBounds(300, 30, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label);

        // Room Bed Type
        JLabel l1 = new JLabel("Room Bed Type");
        l1.setBounds(50, 100, 100, 22);
        add(l1);

        comboBox = new JComboBox(new String[] { "Single Bed", "Double Bed" });
        comboBox.setBounds(200, 100, 150, 22);
        add(comboBox);

        checkBox = new JCheckBox("Only display available");
        checkBox.setBounds(600, 100, 150, 22);
        add(checkBox);

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

        // Room Number
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(50, 160, 100, 22);
        add(l2);

        // Available
        JLabel l3 = new JLabel("Available");
        l3.setBounds(250, 160, 100, 22);
        add(l3);

        // Cleaning Status
        JLabel l4 = new JLabel("Cleaning Status");
        l4.setBounds(450, 160, 100, 22);
        add(l4);

        // Price
        JLabel l5 = new JLabel("Price");
        l5.setBounds(650, 160, 100, 22);
        add(l5);

        // Bed Type
        JLabel l6 = new JLabel(" Bed Type");
        l6.setBounds(850, 160, 100, 22);
        add(l6);

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
                String s1 = (String) comboBox.getSelectedItem();
                String str = "select * from rooms where bed_type = '" + s1 + "'";
                String str2 = "select * from rooms where available = 'Available' and bed_type = '" + s1 + "'";

                if (checkBox.isSelected()) {
                    ResultSet rs2 = c.s.executeQuery(str2);
                    while (rs2.next()) {
                        table.setModel(DbUtils.resultSetToTableModel(rs2));
                    }
                } else {
                    ResultSet rs = c.s.executeQuery(str);
                    while (rs.next()) {
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new SearchRoom();
    }
}
