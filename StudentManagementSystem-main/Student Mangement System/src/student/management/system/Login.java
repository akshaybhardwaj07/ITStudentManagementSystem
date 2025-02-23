package student.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField field_user,field_password;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);

        JLabel label_user=new JLabel("Username");
        label_user.setBounds(40,20,100,30);
        label_user.setForeground(Color.black);
        add(label_user);


        field_user=new JTextField();
        field_user.setBounds(150,20,100,30);
        add(field_user);


        JLabel label_password=new JLabel("Password");
        label_password.setBounds(40,70,100,30);
        label_password.setForeground(Color.black);
      add(label_password);

        field_password=new JTextField();
        field_password.setBounds(150,70,100,30);
        add(field_password);

        JButton login=new JButton("Login");
        login.setBounds(150,150,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        JPanel panel = new JPanel(); // Create a new panel to act as a container
        panel.setBounds(0, 0, 1100, 650);
        panel.setLayout(null);

        add(panel);

    }
    public void actionPerformed(ActionEvent e) {
        try {
            String username = field_user.getText();
            String password = field_password.getText();
            String query = "select * from Login where username ='" + username + "' and password='" + password + "'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()) {
                dispose();
                new Home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username and password");

            }


        } catch (Exception ae)
        {
            ae.printStackTrace();

        }


    }
    public static void main(String[] args) {
        new Login();
    }
}
