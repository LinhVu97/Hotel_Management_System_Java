package hotelManager.main;

import javax.swing.*;

import hotelManager.admin.AddEmployee;

import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4;

    Dashboard() {
        setBounds(0, 0, 1950, 1020);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1950, 30);
        add(menuBar);

        // HOTEL MANAGEMENT
        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.red);
        menuBar.add(m1);

        i1 = new JMenuItem("RECEPTION");
        m1.add(i1);

        // ADMIN
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        menuBar.add(m2);

        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOMS");
        m2.add(i3);

        i4 = new JMenuItem("ADD DRIVERS");
        m2.add(i4);

        // Image
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image img = imgIcon.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT); // Transform Image
        ImageIcon newImg = new ImageIcon(img);
        JLabel label = new JLabel(newImg);
        label.setBounds(0, 0, 1950, 1000);
        add(label);

        // Label
        JLabel lb1 = new JLabel("THE TAJ GROUP WELCOME YOU");
        lb1.setBounds(300, -100, 1000, 500);
        lb1.setForeground(Color.darkGray);
        lb1.setFont(new Font("serif", Font.ITALIC, 50));
        label.add(lb1);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i2) {
            new AddEmployee().setVisible(true);
        }
    }

}
