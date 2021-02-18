package hotelManager.management.reception;

import javax.swing.*;

import hotelManager.main.conn;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5;

    public Room() {
        setBounds(150, 100, 1050, 570);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(550, 50, 450, 450);
        add(image);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        b1 = new JButton("Load Data");
        b1.setBounds(100, 460, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250, 460, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        l1 = new JLabel("Room Number");
        l1.setBounds(12, 15, 90, 14);
        add(l1);

        l2 = new JLabel("Available");
        l2.setBounds(110, 15, 90, 14);
        add(l2);

        l3 = new JLabel("Status");
        l3.setBounds(220, 15, 90, 14);
        add(l3);

        l4 = new JLabel("Price");
        l4.setBounds(320, 15, 90, 14);
        add(l4);

        l5 = new JLabel("Bed Type");
        l5.setBounds(420, 15, 90, 14);
        add(l5);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from rooms";
                ResultSet rs = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception err) {
                err.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new Room();
    }

}
