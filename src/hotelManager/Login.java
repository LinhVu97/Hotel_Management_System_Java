package hotelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel lb1, lb2;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1, btn2;

    Login() {
        setBounds(250, 150, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Username
        lb1 = new JLabel("Username");
        lb1.setBounds(40, 20, 100, 30);
        add(lb1);

        tf1 = new JTextField();
        tf1.setBounds(150, 20, 150, 30);
        add(tf1);

        // Password
        lb2 = new JLabel("Password");
        lb2.setBounds(40, 60, 100, 30);
        add(lb2);

        tf2 = new JPasswordField();
        tf2.setBounds(150, 60, 150, 30);
        add(tf2);

        // Button
        btn1 = new JButton("Login");
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.white);
        btn1.setBounds(40, 150, 120, 30);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Cancel");
        btn2.setBounds(180, 150, 120, 30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.white);
        btn2.addActionListener(this);
        add(btn2);

        // Image
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("hotelManager/icons/second.jpg"));
        Image img = imgIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Transform Image
        ImageIcon newImg = new ImageIcon(img);
        JLabel lb3 = new JLabel(newImg);
        lb3.setBounds(350, 10, 200, 200);
        add(lb3);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String username = tf1.getText();
            char[] pw = tf2.getPassword();
            String password = new String(pw);
            conn c = new conn();

            String str = "select * from login where username = '" + username + "' and password = '" + password + "'";

            try {
                ResultSet rs = c.s.executeQuery(str);
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username and password");
                    this.setVisible(true);
                }
            } catch (Exception err) {

            }

        } else if (e.getSource() == btn2) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this window?", "Close Window?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
