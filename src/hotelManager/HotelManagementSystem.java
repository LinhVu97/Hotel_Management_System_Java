package hotelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    HotelManagementSystem() {
        setBounds(0, 100, 1366, 565); // ( (x, y), (width, height) ) = (setLocation, setSize)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Background image
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("hotelManager/icons/first.jpg")));
        add(background);

        // Label
        JLabel label = new JLabel("Hotel Management System");
        label.setBounds(20, 450, 1000, 70);
        label.setForeground(Color.white);
        label.setFont(new Font("serif", Font.ITALIC, 50));
        background.add(label);

        // Button
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(1150, 450, 150, 50);
        b1.addActionListener(this);
        background.add(b1);

        setVisible(true); // Hien thi

        while (true) {
            label.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }

            label.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }
}
