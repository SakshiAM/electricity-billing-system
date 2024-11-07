package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class PayBill extends JFrame implements ActionListener  {
    
    Choice cmonth;
    JButton pay, back,gpay;
    String meter;
    PayBill(String meter) {
        this.meter = meter;
        setSize(1000,900);
        setLayout(null);
        
        setBounds(300,150,900,600);
                
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/paytm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
         add(image);
         
        JLabel heading = new JLabel("Electicity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD,24));
        heading.setBounds(120, 5, 400, 30);
        image.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(35, 80, 200, 20);
        image.add(lblmeternumber);
        
        
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(300, 80, 200, 20);
        image.add(meternumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 140, 150, 20);
        image.add(lblname);
        
        JLabel labelname = new JLabel("");
        labelname.setBounds(300, 140, 200, 20);
        image.add(labelname);
        
        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 200, 200, 20);
        image.add(lblmonth);
        
        cmonth = new Choice();
        cmonth.setBounds(250, 200, 80, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        image.add(cmonth);
        
         JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35, 260, 200, 20);
        image.add(lblunits);
        
        JLabel labelunits = new JLabel("");
        labelunits.setBounds(300, 280, 200, 20);
        image.add(labelunits);
        
        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35, 320, 200, 20);
        image.add(lbltotalbill);
        
        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(300, 320, 200, 20);
        image.add(labeltotalbill);
        
        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(35, 380, 200, 20);
        image.add(lblstatus);
        
        JLabel labelstatus = new JLabel("");
        labelstatus.setBounds(300, 380, 200, 20);
        labelstatus.setForeground(Color.RED);
        image.add(labelstatus);
        
         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()) {
                meternumber.setText(meter);
                  labelname.setText(rs.getString("name"));
            }
            
            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = 'January'");
            while(rs.next()) {
                labelunits.setText(rs.getString("units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                labelstatus.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         cmonth.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month = '"+cmonth.getSelectedItem()+"'");
                    while(rs.next()) {
                        labelunits.setText(rs.getString("units"));
                        labeltotalbill.setText(rs.getString("totalbill"));
                        labelstatus.setText(rs.getString("status"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
         
          back = new JButton("back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK );
        back.setBounds(560, 500, 100, 40);
        back.addActionListener(this);
        image.add(back);
        
       pay = new JButton("Paytm");
        pay.setBackground(Color.white);
        pay.setForeground(Color.BLACK);
        pay.setBounds(200, 500, 150, 40);
        pay.addActionListener(this);
        image.add(pay);
        
         gpay= new JButton("Google pay");
        gpay.setForeground(Color.black);
        gpay.setBackground(Color.white);
        gpay.setBounds(380, 500, 150, 40);
        gpay.addActionListener(this);
       image.add(gpay);

       getContentPane().setBackground(Color.WHITE);
        
       
        
        setResizable(false);
        setVisible(true);
    }
       
        
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        }
        else if(ae.getSource() == gpay)
        {try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Gpay("","");
        }
        else {
            setVisible(false);
        }
    }
        
    public static void main(String[] args) {
        new PayBill("");
    }

}
