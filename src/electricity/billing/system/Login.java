package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel,signup;
    JTextField username;
    Choice logginin;
         JPasswordField password;

    Login() {
         super("Login Page");
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
         lblusername.setBounds(30, 100, 100, 20);
         lblusername.setFont(new Font("serif",Font.BOLD,20));
         lblusername.setForeground(Color.WHITE);
         add(lblusername);
         
         
         username = new JTextField();
         username.setBounds(160, 100, 150, 25);
         add(username);
         
         JLabel lb1password= new JLabel("Password");
         lb1password.setFont(new Font("Tahoma", Font.PLAIN, 16));
         lb1password.setForeground(Color.WHITE);
         lb1password.setFont(new Font("serif",Font.BOLD,20));
         lb1password.setBounds(30, 150, 100, 20);
         add(lb1password);
         
         password = new JPasswordField();
         password.setBounds(160, 150, 150, 25);
         add(password);
         
         JLabel loggininas= new JLabel("Loggin in as");
         loggininas.setFont(new Font("Tahoma", Font.PLAIN, 16));
         loggininas.setFont(new Font("serif",Font.BOLD,20));
         loggininas.setBounds(30, 200, 120, 20);
         loggininas.setForeground(Color.WHITE);
         add(loggininas);
         
          logginin = new Choice();
         logginin.add("Admin");
         logginin.add("Customer");
         logginin.setFont(new Font("Tahoma", Font.PLAIN, 16));

         logginin.setBounds(160, 200, 150, 25);
         add(logginin);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 =i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        
        
         login = new JButton("Login",new ImageIcon(i2));
         login.setBounds(30, 250, 100, 25);
          login.addActionListener(this);
         add(login);
        
         ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
         Image i4 =i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
         
         
         cancel = new JButton("Cancel", new ImageIcon(i4));
         cancel.setBounds(100, 300, 100, 25);
         cancel.addActionListener(this);
          add(cancel);
         
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png")); 
        Image i6 =i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        
        
         signup= new JButton("Signup", new ImageIcon(i6));
         signup.setBounds(170, 250, 100, 25);
         signup.addActionListener(this);
         add(signup);
         
         
         ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpeg")); 
        Image i8 =i7.getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image =new JLabel(i9);
        image.setBounds(0, 0, 750, 500);
        add(image);
      
        
        setSize(750,500);
        setLocation(400,150);
        setVisible(true);
        
    }
  public void actionPerformed(ActionEvent ae){
      if (ae.getSource()== login) {
          
          String susername = username.getText();
          String spassword = password.getText();
          String user = logginin.getSelectedItem();
          
          try{
           Conn c = new Conn();
           String query = "select * from login where( username = '"+susername+"'  and password = '"+spassword+"' and  user = '"+user+"')";
          
           ResultSet rs = c.s.executeQuery(query);
           
           if (rs.next()){
               String meter = rs.getString("meter_no");
               
               setVisible(false);
               new Project(user,meter);
           } else { 
               JOptionPane.showMessageDialog(null, "Invalid Login");
               
               username.setText("");
               password.setText("");
           }
          }catch(Exception e) {
              e.printStackTrace();
          }
      } else if (ae.getSource()== cancel) {
          setVisible(false);
      } else if (ae.getSource()== signup) {
          setVisible(false);
          
          new Signup();
      }
      
  }
public static void main(String args[]) {
    new Login();

    
}
}

