package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JButton b1, b2;
    JTable table;

    public Department() {
        table = new JTable();
        table.setBounds(0, 50, 500, 300);
        add(table);

        // Button
        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180, 400, 120, 30);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380, 400, 120, 30);
        add(b2);

        // Name
        JLabel l2 = new JLabel("Department");
        l2.setBounds(100, 10, 100, 22);
        add(l2);

        // Age
        JLabel l3 = new JLabel("Budget");
        l3.setBounds(300, 10, 100, 22);
        add(l3);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(150, 100, 700, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from department";

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
        new Department();
    }
}
