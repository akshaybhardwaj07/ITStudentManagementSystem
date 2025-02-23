package student.management.system;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,view,update,remove;
    Home()

    {
        setSize(1120,630);
        setVisible(true);
        setLocation(150,100);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading=new JLabel("Student Management System");
        heading.setBounds(370,190,400,40);
        heading.setFont(new Font("SERIF",Font.ITALIC,32));
        heading.setForeground(Color.white);
        image.add(heading);

        add=new JButton("Add Student");
        add.setBounds(420,280,150,30);
        add.setBackground(Color.white);
        add.setForeground(Color.black);
        add.addActionListener(this);
       image.add(add);

       view=new JButton("View Student");
        view.setBounds(600,280,150,30);
        view.setBackground(Color.white);
        view.setForeground(Color.black);
        view.addActionListener(this);
        image.add(view);

       update=new JButton("Update Student");
        update.setBounds(420,320,150,30);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
       update.addActionListener(this);
        image.add(update);

        remove=new JButton("Remove Student");
        remove.setBounds(600,320,150,30);
        remove.setBackground(Color.white);
        remove.setForeground(Color.black);
      remove.addActionListener(this);
        image.add(remove);

    }
    public void actionPerformed(ActionEvent ae)
    {
        dispose();
        if(ae.getSource()==add)
        {
          new Add();
        }
        else if(ae.getSource()==view)
        {
            new View();
        }
        else if(ae.getSource()==update)
        {
            new View();
        }
        else {
            new Remove();
        }


    }
    public static void main(String[] args) {
        new Home();
    }
}
