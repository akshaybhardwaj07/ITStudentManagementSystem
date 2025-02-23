package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    private final JLabel heading;
    private final Timer timer;

    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(1100, 650);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading = new JLabel("Student Management System");
        heading.setBounds(200, 50, 1200, 50);
        heading.setFont(new Font("Serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLACK);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 120, 950, 400);
        add(image);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1100, 650);
        panel.setLayout(null);

        JButton click = new JButton("Admin Login");
        click.setBounds(350, 250, 300, 70);
        click.setBackground(Color.white);
        click.setForeground(Color.black);
        click.addActionListener(this);
        image.add(click);

        add(panel);

        timer = new Timer(500, this); // Timer to toggle heading visibility every 500 milliseconds
        timer.setInitialDelay(0); // Start the timer immediately
        timer.start();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            heading.setVisible(!heading.isVisible()); // Toggle the visibility of the heading label
        } else {
            dispose();
            new Login();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
