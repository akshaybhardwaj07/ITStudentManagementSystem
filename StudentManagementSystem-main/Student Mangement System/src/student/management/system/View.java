package student.management.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View extends JFrame implements ActionListener {
    JTable table;
    JTextField input;
    JButton search,print,update,home;

    View()
    {
        getContentPane().setBackground(Color.white);
        setSize(900,600);
        setLocation(300,100);
        setVisible(true);
        setLayout(null);

        JLabel searchR=new JLabel("Search By Roll number");
        searchR.setBounds(20,20,150,20);
        add(searchR);

        input=new JTextField();
        input.setBounds(200,20,150,20);
        add(input);


        table =new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");


            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        search.addActionListener(this);
        add(search);

        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.white);
        print.setForeground(Color.black);
        print.addActionListener(this);
        add(print);

        update =new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.addActionListener(this);
        add(update);

        home =new JButton("Home");
        home.setBounds(320,70,80,20);
        home.setBackground(Color.white);
        home.setForeground(Color.black);
        home.addActionListener(this);
        add(home);




    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search)
        {
            String roll=input.getText();
            String query="select * from student where roll='"+roll+"'";
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
      else if(ae.getSource()==print)
        {
            try{
                table.print();

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
      else if(ae.getSource()==update)
        {
            String roll=input.getText();
            dispose();
            new Update(roll);
        }
      else {
          dispose();
          new Home();
        }

    }

    public static void main(String[] args) {
        new View();
    }
}
