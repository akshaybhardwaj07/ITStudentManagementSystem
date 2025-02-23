package student.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Remove extends JFrame implements ActionListener {
    JTextField input;
    JButton delete,Home;
    JTable table;
    JScrollPane jsp;
    Remove()
    {   getContentPane().setBackground(Color.white);
        setSize(900,600);
        setLocation(300,50);
        setVisible(true);
        setLayout(null);

        JLabel roll=new JLabel("Search By Roll Number");
        roll.setBounds(50,50,200,20);
        add(roll);
        input=new JTextField();
        input.setBounds(250,50,100,20);
        add(input);
        delete=new JButton("Delete");
        delete.setBounds(150,100,150,20);
        delete.setBackground(Color.white);
        delete.setForeground(Color.black);
        delete.addActionListener(this);
        add(delete);
        Home=new JButton("Home Page");
        Home.setBounds(350,100,150,20);
        Home.setBackground(Color.white);
        Home.setForeground(Color.black);
        Home.addActionListener(this);
        add(Home);



        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       jsp=new JScrollPane(table);
        jsp.setBounds(0,150,900,600);
        add(jsp);


    }
    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==delete)
        {
            String roll=input.getText();
            String query="delete from student where roll='"+roll+"'";
            try{
                Conn c=new Conn();
               int s=c.s.executeUpdate(query);
               if(s>0)
               {
                   JOptionPane.showMessageDialog(null,"Removed Successfully");
                   ResultSet rs=c.s.executeQuery("select * from student");
                   table=new JTable();
                   table.setModel(DbUtils.resultSetToTableModel(rs));
                   jsp=new JScrollPane(table);
                   jsp.setBounds(0,150,900,600);
                   add(jsp);

               }
               else {
                   JOptionPane.showMessageDialog(null,"Incorrect Roll number");
               }

            }catch (Exception ae)
            {
                ae.printStackTrace();
            }
        } else if (e.getSource()==Home) {
            dispose();
            new Home();

        }
    }
    public static void main(String[] args) {
        new Remove();
    }
}
