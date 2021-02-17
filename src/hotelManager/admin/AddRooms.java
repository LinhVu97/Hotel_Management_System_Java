package hotelManager.admin;

import hotelManager.main.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    private JTextField t1, t2;
    private JComboBox comboBox, comboBox_1, comboBox_2;
    JButton b1, b2;
    Choice c1;

    public AddRooms() {
        setBounds(200, 50, 1000, 500);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // Label
        JLabel AddRooms = new JLabel("Add Rooms");
        AddRooms.setFont(new Font("Tahoma", Font.BOLD, 18));
        AddRooms.setBounds(194, 10, 120, 22);
        add(AddRooms);

        // Room Number
        JLabel RoomNumber = new JLabel("Room Number");
        RoomNumber.setForeground(new Color(25, 25, 112));
        RoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        RoomNumber.setBounds(64, 70, 102, 22);
        add(RoomNumber);

        t1 = new JTextField();
        t1.setBounds(200, 70, 150, 30);
        add(t1);

        // Available
        JLabel Available = new JLabel("Availability");
        Available.setForeground(new Color(25, 25, 112));
        Available.setFont(new Font("Tahoma", Font.BOLD, 14));
        Available.setBounds(64, 120, 102, 22);
        add(Available);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(200, 120, 150, 30);
        add(comboBox);

        // Cleaning
        JLabel Cleaning = new JLabel("Cleaning Status");
        Cleaning.setForeground(new Color(25, 25, 112));
        Cleaning.setFont(new Font("Tahoma", Font.BOLD, 14));
        Cleaning.setBounds(64, 170, 200, 22);
        add(Cleaning);

        comboBox_1 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_1.setBounds(200, 170, 150, 30);
        add(comboBox_1);

        // Price
        JLabel Price = new JLabel("Price");
        Price.setForeground(new Color(25, 25, 112));
        Price.setFont(new Font("Tahoma", Font.BOLD, 14));
        Price.setBounds(64, 220, 102, 22);
        add(Price);

        t2 = new JTextField();
        t2.setBounds(200, 220, 150, 30);
        add(t2);

        // Bed Type
        JLabel Bed = new JLabel("Bed Type");
        Bed.setForeground(new Color(25, 25, 112));
        Bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        Bed.setBounds(64, 270, 102, 22);
        add(Bed);

        comboBox_2 = new JComboBox(new String[] { "Single Bed", "Double Bed" });
        comboBox_2.setBounds(200, 270, 150, 30);
        add(comboBox_2);

        // Button
        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                try {
                    String room = t1.getText();
                    String available = (String) comboBox.getSelectedItem();
                    String status = (String) comboBox_1.getSelectedItem();
                    String price = t2.getText();
                    String type = (String) comboBox_2.getSelectedItem();

                    String str = "INSERT INTO rooms values( '" + room + "', '" + available + "', '" + status + "','"
                            + price + "', '" + type + "')";

                    conn c = new conn();
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            } else if (e.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new AddRooms();
    }
}
