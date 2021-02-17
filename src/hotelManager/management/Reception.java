package hotelManager.management;

import javax.swing.*;

import hotelManager.main.Dashboard;
import hotelManager.main.Login;

import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    public Reception() {
        setBounds(250, 100, 850, 570);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image img = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(img);
        JLabel l1 = new JLabel(image);
        l1.setBounds(250, 30, 500, 470);
        add(l1);

        // New Custom Form
        b1 = new JButton("New Custom Form");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b1.setBounds(10, 30, 200, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        // Room
        b2 = new JButton("Room");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b2.setBounds(10, 70, 200, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        // Department
        b3 = new JButton("Department");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b3.setBounds(10, 110, 200, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        // All employee Information
        b4 = new JButton("All Employee Info");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b4.setBounds(10, 150, 200, 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        add(b4);

        // Customer Information
        b5 = new JButton("Customer Info");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b5.setBounds(10, 190, 200, 30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        add(b5);

        // Manager Info
        b6 = new JButton("Manager Info");
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b6.setBounds(10, 230, 200, 30);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        add(b6);

        // Check out
        b7 = new JButton("Check Out");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b7.setBounds(10, 270, 200, 30);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        add(b7);

        // Update check status
        b8 = new JButton("Update Check Status");
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b8.setBounds(10, 310, 200, 30);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        add(b8);

        // Update room Status
        b9 = new JButton("Update Room Status");
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b9.setBounds(10, 350, 200, 30);
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        add(b9);

        // Pick up service
        b10 = new JButton("Pick up Service");
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b10.setBounds(10, 390, 200, 30);
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        add(b10);

        // Search room
        b11 = new JButton("Search Room");
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        b11.setBounds(10, 430, 200, 30);
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        add(b11);

        // Logout
        b12 = new JButton("Log Out");
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                setVisible(false);
            }
        });
        b12.setBounds(10, 470, 200, 30);
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        add(b12);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Reception();
    }

}