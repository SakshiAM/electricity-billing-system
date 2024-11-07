package electricity.billing.system;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Gpay extends JFrame implements Runnable{
        Thread thread;
 String meter,month;
     Gpay(String meter,String month)
    { this.meter = meter;
    this.month = month;
    
         setSize(400, 600);
        setLocation(200, 0);
        setLayout(null);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Gpay.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 400, 600);
        add(image);
         setVisible(true); 
          thread =new Thread(this);
        thread.start();
    
    }
     
      public void run()
    {
        try{
            Thread.sleep(5000);
            setVisible(false);
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' AND month='"+month+"'");
            } catch (Exception f) {
                
            }
        }catch(Exception e){}
    
    }
    
    public static void main(String arge[])
    {
        new Gpay("",""); 
    } 
    
}
