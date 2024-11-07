package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Signup extends JFrame implements ActionListener{
    JButton create,back;
     JLabel lblpassword,lblname,lblusername,lblmeter, heading;
     JPanel panel;
     Choice accountType;
     JTextField meter,username,name;
     JPasswordField password;
     
    Signup() 
            
    {
         super("Signup Page");
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
    
        

        heading = new JLabel("Create Account");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
      add(heading);
        
        
        accountType = new Choice();
         accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
      add(accountType);
        
        
        
        
        lblmeter= new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        add(lblmeter);
        
        meter  = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
       add(meter);
         
         accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(true);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
                 
         lblusername= new JLabel("Username");
       lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblusername);
        
         username  = new JTextField();
        username.setBounds(260, 130, 150, 20);
         add(username);
         
        
          lblname= new JLabel("Name");
       lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
         add(lblname);
        
          name  = new JTextField();
        name.setBounds(260, 170, 150, 20);
        add(name);
         
          meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
         
         lblpassword= new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblpassword);
        
         password  = new JPasswordField();
       password.setBounds(260, 210, 150, 20);
         add(password);
         
         create = new JButton("Create");
         create.setBounds(140, 260, 120, 25);
         create.setBackground(Color.BLACK);
         create.setForeground(Color.WHITE);
         create.addActionListener(this);
         add(create);
         
          back = new JButton("Back");
         back.setBounds(300, 260, 120, 25);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
         
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sp.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 400);
        add(image);
         
         
       setResizable(false);

        setVisible(true);
    } 

    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== create)
         {
             String atype = accountType.getSelectedItem();
             String susername=username.getText();
             String sname=name.getText();
             String spassword=password.getText();
             String smeter=meter.getText();
            
              try{
           Conn c = new Conn();
           String query = "select * from login where( username = '"+susername+"')";
          
           ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                
                 JOptionPane.showMessageDialog(null,"username alredy exist ");
               
           } else { 
              
          
            if (isValidName(sname)) 
            {
               
            JOptionPane.showMessageDialog(null,"please enter valid name");
            }
         
            
            else{
             
              try {
                Conn c1 = new Conn();
                
                String query1 = null;
                if (atype.equals("Admin")) {
                    query1 = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                } else {
                    query1 = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c1.s.executeUpdate(query1);
            
            JOptionPane.showMessageDialog(null,"Account Created Successfully");
             setVisible(false);
              new Login();
            }
            catch(Exception e)
             {
               e.printStackTrace();
             }
              
          }
             }
          
          }catch(Exception e) {
              e.printStackTrace();
          }
         }
         
         else if (ae.getSource()== back) 
         {
           setVisible(false);
           new Login();
          
         }
        
    }
  private boolean isValidName(String name) 
    {
     
      return name.matches("^[0-9]+$");
    
    }
     public static void main(String args[]) 
     {
        new Signup();
        
     }
}

