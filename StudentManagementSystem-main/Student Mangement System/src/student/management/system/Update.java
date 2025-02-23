package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Update extends JFrame implements ActionListener {
    JButton update,back;
    JTextField input_father,input_section;



    JComboBox  input_branch;
    String rollno;
    Update(String rollno)
    {
        this.rollno=rollno;
        getContentPane().setBackground(Color.white);
        setSize(900,600);
        setLocation(300,50);
        setVisible(true);
        setLayout(null);

        JLabel heading =new JLabel("Update Student Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SERIF",Font.BOLD,25));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,100,150,30);
        name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(name);

        JLabel lblname=new JLabel();
        lblname.setBounds(250,100,200,30);
        add(lblname);

        JLabel father_name=new JLabel("Father's Name");
        father_name.setBounds(50,150,150,30);
        father_name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(father_name);

        input_father=new JTextField();
        input_father.setBounds(250,150,200,30);
        add(input_father);


        JLabel DOB =new JLabel("Date of Birth");
        DOB.setBounds( 50,200,150,30);
        DOB.setFont(new Font("SERIF",Font.PLAIN,20));
        add(DOB);

        JLabel lbldob=new JLabel();
        lbldob.setBounds( 250,200,200,30);
        add(lbldob);


        JLabel branch=new JLabel("Branch");
        branch.setBounds(50,250,150,30);
        branch.setFont(new Font("SERIF",Font.PLAIN,20));
        add(branch);

        String arr[]={"CSE","CS","IT","EN","ECE","CS-AIML","CSDS"};
        input_branch=new JComboBox(arr);
        input_branch.setBackground(Color.white);
        input_branch.setBounds(250,250,200,30);
        add(input_branch);

        JLabel section=new JLabel("Section");
        section.setBounds(50,300,150,30);
        section.setFont(new Font("SERIF",Font.PLAIN,20));
        add(section);

        input_section=new JTextField();
        input_section.setBounds(250,300,200,30);
        add(input_section);

        JLabel roll_no=new JLabel("Roll Number");
        roll_no.setBounds(50,350,150,30);
        roll_no.setFont(new Font("SERIF",Font.PLAIN,20));
        add(roll_no);

        JLabel lblroll=new JLabel();
        lblroll.setBounds(250,350,200,30);
        add(lblroll);

        try
        {
            Conn c=new Conn();
            String query="select * from student where roll='"+this.rollno+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("Name"));
                input_father.setText(rs.getString("Father_name"));
                lbldob.setText(rs.getString("DOB"));
                input_section.setText(rs.getString("Section"));
                lblroll.setText(rs.getString("Roll"));
                input_branch.setSelectedItem(rs.getString("Branch"));


            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        update=new JButton("Update Details");
        update.setBounds(250,450,150, 40);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.addActionListener(this);
        add(update);

        back =new JButton("Home Page");
        back.setBounds(450,450,150,40);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {

            String Father_name=input_father.getText();
            String branch=(String) input_branch.getSelectedItem();
            String section=input_section.getText();

            try{
                Conn conn=new Conn();
                String query="update student set Father_name='"+Father_name+"',Branch='"+branch+"',Section='"+section+"' where Roll='"+rollno+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                dispose();
                new View();

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else {
            dispose();
            new Home();
        }
    }
    public static void main(String[] args) {
        new Update("");

    }
}
