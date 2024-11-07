package electricity.billing.system;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.regex.*;

public class NewCustomer extends JFrame implements ActionListener

{

  JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblmeter;
    JFrame f;
    NewCustomer() {
        setSize(800, 600);
        setLocation(400, 200);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 250, 250));
       
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(30, 70, 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(180, 80, 200, 20);
        add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(40, 120, 100, 20);
         add(lblmeterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(180, 120, 100, 20);
         add(lblmeter);
        
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(40, 160, 100, 20);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(180, 160, 200, 20);
         add(tfaddress);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(40, 200, 100, 20);
         add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(180, 200, 200, 20);
         add(tfcity);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(40, 240, 100, 20);
         add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(180, 240, 200, 20);
        add(tfstate);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40, 280, 100, 20);
         add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(180, 280, 200, 20);
        add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(30, 320, 100, 15);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(180, 320, 200, 20);
        add(tfphone);
        
        next = new JButton("Next");
        next.setBounds(120, 390, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
       add(cancel);
        
        
        
      
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fan.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(420, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(380, 75, 500, 450);
        add(image);
        
       
        
        setVisible(true);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            
            
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            if(tfname.getText().trim().isEmpty()||lblmeter.getText().trim().isEmpty()||tfaddress.getText().trim().isEmpty()||tfcity.getText().trim().isEmpty()||tfstate.getText().trim().isEmpty()||tfemail.getText().trim().isEmpty()||tfphone.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
    
            
            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";
            if (!isValidPhoneNumber(phone)) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid phone  number.");
            
            }
            else  if (isValidName(name)) 
            {
               
            JOptionPane.showMessageDialog(null,"please enter valid name");
            }
            else  if (!isValidEmail(email)) 
            {
               
            JOptionPane.showMessageDialog(null,"please enter valid email");
            }
            
            else{
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
                
                 new MeterInfo(meter );
                
               
            } 
            catch (Exception e){
                e.printStackTrace();
            }
        } }
           else {
            setVisible(false);
                }
      }
     private boolean isValidName(String name) 
    {
     
      return name.matches("^[0-9]+$");
    
    }
    private boolean isValidPhoneNumber(String phone) 
    {
     String phoneRegex = "^[0-9]{10}$";
     return phone.matches(phoneRegex);
    }
    
    private boolean isValidEmail(String email) 
    {
        String emailRegex = "^[a-z0-9+_.-]+@(.+\\.com)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void main(String[] args) 
    {
        new NewCustomer();
    }
}
