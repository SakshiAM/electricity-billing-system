package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

  public class Splash extends JFrame implements Runnable {
       Thread thread;
     Splash(String username)
     {
      
        setSize(1000,600);
        setLocation(250,100);
        setLayout(null);
         
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/GIF"));
         Image i2= i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 1000, 600);
           add(image);
           
           JLabel lid=new JLabel("ELECTRICITY  BILING SYSTEM");
                 lid.setBounds(30,350,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.white);
                
                image.add(lid);
                 setVisible(true); thread =new Thread(this);thread.start();
         while(true){
                        lid.setVisible(false); 
                    try{
                        Thread.sleep(500); 
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	
       
       
        
     }
       public void run()
    {
        
        try{
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        }catch(Exception e){}
    
    }
    
        
  
   public static void main(String args[]) {
       
       new Splash("");
   }
}


