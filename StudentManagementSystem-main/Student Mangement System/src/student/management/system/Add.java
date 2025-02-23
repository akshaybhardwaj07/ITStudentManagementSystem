package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

public class Add extends JFrame implements ActionListener {
    JButton add,back;
    JTextField input_name,input_father, input_roll,input_section;
    JDateChooser dob;


    JComboBox  input_branch;
    Add()
    {
        getContentPane().setBackground(Color.white);
        setSize(900,600);
        setLocation(300,50);
        setVisible(true);
        setLayout(null);

        JLabel heading =new JLabel("Add Student Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SERIF",Font.BOLD,25));
        add(heading);

        JLabel name=new JLabel("Name");
        name.setBounds(50,100,150,30);
        name.setFont(new Font("SERIF",Font.PLAIN,20));
        add(name);

         input_name=new JTextField();
        input_name.setBounds(250,100,200,30);
        add(input_name);

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

        dob=new JDateChooser();
        dob.setBounds( 250,200,200,30);
        add(dob);


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

        input_roll=new JTextField();
        input_roll.setBounds(250,350,200,30);
        add(input_roll);

        add=new JButton("Add Details");
        add.setBounds(250,450,150, 40);
        add.setBackground(Color.white);
        add.setForeground(Color.black);
        add.addActionListener(this);
        add(add);

        back =new JButton("Home Page");
        back.setBounds(450,450,150,40);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String name=input_name.getText();
            String Father_name=input_father.getText();
            String roll=input_roll.getText();
            String date= ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String branch=(String) input_branch.getSelectedItem();
            String section=input_section.getText();
            System.out.println(date);

            try{
                Conn conn=new Conn();
                String query="insert into student values('"+name+"','"+Father_name+"','"+roll+"','"+branch+"','"+section+"','"+date+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                dispose();
                new Add();

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
        new Add();

    }
}
