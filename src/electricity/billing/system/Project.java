package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    String atype, meter;

    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/a2.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 750, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

    JMenuBar mb = new JMenuBar(); 
    setJMenuBar(mb);
         
        
        
        ImageIcon imageIcon7 = new ImageIcon(ClassLoader.getSystemResource("icon/master-data.png"));
        Image imagee = imageIcon7.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon8 = new ImageIcon(imagee);
        JLabel imagef = new JLabel(imageIcon8);
        
        
    JMenu master = new JMenu("Master");
    master.setFont(new Font("tahoma", Font.BOLD, 20));
    master.setForeground(Color.BLUE);

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.setBackground(Color.WHITE);
        newcustomer.setForeground(Color.red);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('C');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerdetails.setBackground(Color.WHITE);
        customerdetails.setForeground(Color.red);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('D');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositdetails.setBackground(Color.WHITE);
        depositdetails.setForeground(Color.red);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('S');
        depositdetails.addActionListener(this);
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebill.setBackground(Color.WHITE);
        calculatebill.setForeground(Color.red);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('B');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);
         
    JMenu  o = new JMenu(" ");      
        JMenu  o1 = new JMenu("                                                                                                                                                                                                                                                                                                                                                                                                                         ");  
    JMenu  o2 = new JMenu("                                                                                                                                                                                                                                                                                                       ");  
        ImageIcon imageIcon5 = new ImageIcon(ClassLoader.getSystemResource("icon/file.png"));
        Image imagec = imageIcon5.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imagec);
        JLabel imaged = new JLabel(imageIcon6);
        
        
    JMenu info = new JMenu("Information       ");
    info.setFont(new Font("tahoma", Font.BOLD, 20));
    info.setForeground(Color.red);
        
        
        
        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image imagea = imageIcon3.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon4 = new ImageIcon(imagea);
        JLabel imageb = new JLabel(imageIcon4);
       
        
    JMenu user = new JMenu("User        ");
    user.setFont(new Font("tahoma", Font.BOLD, 20));
    user.setForeground(Color.BLUE);
        
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("tahoma", Font.PLAIN, 12));
        updateinformation.setBackground(Color.WHITE);
         updateinformation.setForeground(Color.BLUE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/updat.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        updateinformation.setMnemonic('U');
        updateinformation.addActionListener(this);
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateinformation);

        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("tahoma", Font.PLAIN, 12));
        viewinformation.setBackground(Color.WHITE);
        viewinformation.setForeground(Color.BLUE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        viewinformation.setMnemonic('V');
        viewinformation.addActionListener(this);
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(viewinformation);

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("tahoma", Font.PLAIN, 12));
        paybill.setBackground(Color.WHITE);
        paybill.setForeground(Color.red);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('P');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("tahoma", Font.PLAIN, 12));
        billdetails.setBackground(Color.WHITE);
        billdetails.setForeground(Color.red);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('B');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdetails);

        
         ImageIcon imageIcon9 = new ImageIcon(ClassLoader.getSystemResource("icon/goals.png"));
        Image imageg = imageIcon9.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon10 = new ImageIcon(imageg);
        JLabel imageh = new JLabel(imageIcon10);
        
    JMenu report = new JMenu("Report");
        report.setFont(new Font("tahoma", Font.BOLD, 20));
    report.setForeground(Color.RED);

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("tahoma", Font.PLAIN, 12));
        generatebill.setForeground(Color.blue);
        generatebill.setBackground(Color.WHITE);
        
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);

        
   
        ImageIcon imageIcon11 = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image imagei = imageIcon11.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(imagei);
        JLabel imagej = new JLabel(imageIcon12);
         imagej.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 new Login();
                 setVisible(false);
            }});
        
        
        

        if (atype.equals("Admin")) {
            
            mb.add(o);
            mb.add(imagef);
            mb.add(master);
              mb.add(o1);
        } else {
            
            mb.add(o);
            
            mb.add(imaged);
            mb.add(info);
            
             mb.add(imageb);
            mb.add(user);
            
            mb.add(imageh);
            mb.add(report);
            mb.add(o2);
        }
 
        mb.add(imagej);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("New Customer")) {
            new NewCustomer();

        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();

        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();

        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();

        } else if (msg.equals("View Information")) {
            new ViewInformation(meter);

        } else if (msg.equals("Update Information")) {
            new UpdateInformation(meter);

        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);

        }  else if (msg.equals("Pay Bill")) {
            new PayBill(meter);

        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meter);

        }

    }

    public static void main(String[] args) {
        new Project("", "");
    }
}
