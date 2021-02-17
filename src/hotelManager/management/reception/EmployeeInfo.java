package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    public EmployeeInfo() {
        setBounds(150, 30, 1050, 650);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        table = new JTable();
        table.setBounds(0, 40, 1000, 500);
        add(table);

        b1 = new JButton("Load Data");
        b1.setBounds(350, 560, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(550, 560, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        l1 = new JLabel("Name");
        l1.setBounds(40, 10, 70, 20);
        add(l1);

        l2 = new JLabel("Age");
        l2.setBounds(180, 10, 70, 20);
        add(l2);

        l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 70, 20);
        add(l3);

        l4 = new JLabel("Department");
        l4.setBounds(420, 10, 70, 20);
        add(l4);

        l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 70, 20);
        add(l5);

        l6 = new JLabel("Phone");
        l6.setBounds(670, 10, 70, 20);
        add(l6);

        l7 = new JLabel("Address");
        l7.setBounds(790, 10, 70, 20);
        add(l7);

        l8 = new JLabel("Email");
        l8.setBounds(920, 10, 70, 20);
        add(l8);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                try {
                    conn c = new conn();
                    String str = "select * from employee";
                    ResultSet rs = c.s.executeQuery(str);

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            } else if (e.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new EmployeeInfo();
    }
}
