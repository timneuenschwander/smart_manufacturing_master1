import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * WThis is the class GUI. In this class the whole set up of the UX is stored.
 *
 * @author Gruppe 27
 * @version 31.12.2022
 */
public class GUI extends JFrame
{
    // instance variables - replace the example below with your own
    Factory factory1 = new Factory();
    JFrame frame0 = new JFrame();
    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();
    JFrame frame3 = new JFrame();
    JFrame frame4 = new JFrame();
    JFrame frame5 = new JFrame();
    // menubar
    static JMenuBar mb;
    // JMenu
    static JMenu me0, me1, me2, me3;
    // Menu items
    static JMenuItem mi1, mi2;
    // Container
    Container c1 = new Container();
    Container c2 = new Container();
    // Color
    Color myColor1= new Color(0, 0, 153);
    Color myColor2= new Color(204, 229, 255);
    Color myColor3= new Color(247, 247, 247);
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // Menu
        mb = new JMenuBar();
        me0 = new JMenu("Home");
        me1 = new JMenu("Catalogue");
        me2 = new JMenu("Order");
        mi1 = new JMenuItem("Create new order");
        mi2 = new JMenuItem("See order confirmation");
        me3 = new JMenu("About");
        me2.add(mi1);me2.add(mi2);
        mb.add(me0);mb.add(me1);mb.add(me2);mb.add(me3);
        // Set up frame 0
        JFrame frame0 = new JFrame();
        frame0.setTitle("Aeki GUI Home");
        frame0.setSize(800,800);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.setLayout(null);
        frame0.setJMenuBar(mb);
        // Set up content frame 0
        c1 = frame0.getContentPane();
        JPanel panel0 = new JPanel();
        panel0.setLayout(null);
        panel0.setBounds(10,10,780,260); 
        panel0.setBackground(myColor1);
        String text01 = "Welcome to Aeki";
        String text02 =  "<br /><br />We offer a petite selection of armchairs and sofas in carefully chosen styles, colors and fabrics. Whether you are looking for a classic or a modern model, we have the perfect piece for you. The design applied is timeless and fits perfectly in every home. Our furniture is made with high quality sustainable materials and attention to detail, giving you a piece of furniture that you will enjoy for many years to come. With our excellent customer service and fast delivery, you can be sure that your purchase will be a pleasant experience. <br /> <br /> Thank you for choosing us!";       
        JLabel label01 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:30px'><font color='#C2DFFF'>"+text01+"</font></body></body></html>");
        JLabel label02 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:12px'><font color='#C2DFFF'>"+text02+"</font></body></body></html>");
        label01.setBounds(10, 10, 580, 40);
        label02.setBounds(10, 20, 760, 240);
        panel0.add(label01);
        panel0.add(label02);
        
        JLabel label03 = new JLabel();
        label03.setIcon(new ImageIcon("Picture0.jpg"));
        Dimension size03 = label03.getPreferredSize();
        label03.setBounds(10, 280, 780, 460);
        panel0.add(label03);
        
        c1.add(panel0);
        c1.add(label03);
        frame0.setVisible(true);
        
        //Navigate frames
        me0.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e)
            {
                if (e.getSource() == me0) {
                frame1.setVisible(true);
                frame1.setTitle("Aeki GUI Home");
                frame1.setSize(800,800);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                frame1.setJMenuBar(mb);
                setUpHomeFrame(frame1);
                frame0.dispose();frame2.dispose();frame3.dispose();frame4.dispose();frame5.dispose();
            }
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}  
            public void mousePressed(MouseEvent e){}  
            public void mouseReleased(MouseEvent e){}
        });
        
        me1.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e)
            {
                if (e.getSource() == me1) {
                frame2.setVisible(true);
                frame2.setTitle("Aeki GUI Catalogue");
                frame2.setSize(800,800);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                frame2.setJMenuBar(mb);
                setUpCatalogueFrame(frame2);
                frame0.dispose();frame1.dispose();frame3.dispose();frame4.dispose();frame5.dispose();
                }
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}  
            public void mousePressed(MouseEvent e){}  
            public void mouseReleased(MouseEvent e){}
        });
        
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame3.setVisible(true);
                frame3.setTitle("Aeki GUI Create Order");
                frame3.setSize(800,800);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                frame3.setJMenuBar(mb);
                setUpOrderFrame(frame3);
                frame0.dispose();frame1.dispose();frame2.dispose();frame4.dispose();frame5.dispose();
            }
        });
        
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame4.setVisible(true);
                frame4.setTitle("Aeki GUI See Order Confirmation");
                frame4.setSize(800,800);
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                frame4.setJMenuBar(mb);
                setUpConfiramtionFrame(frame4);
                frame0.dispose();frame1.dispose();frame2.dispose();frame3.dispose();frame5.dispose();
            }
        });
        
        me3.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e)
            {
                if (e.getSource() == me3) {
                frame5.setVisible(true);
                frame5.setTitle("Aeki GUI About");
                frame5.setSize(800,800);
                frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                frame5.setJMenuBar(mb);
                setUpAboutFrame(frame5);
                frame0.dispose();frame1.dispose();frame2.dispose();frame3.dispose();frame4.dispose();
                }
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}  
            public void mousePressed(MouseEvent e){}  
            public void mouseReleased(MouseEvent e){}
        });
    }
    
    /** 
    * @param set the the design and content of the home frame
    */
    public void setUpHomeFrame(JFrame homeFrame)
    {
        //Panel frame 1
        c1.removeAll();
        c1 = getContentPane();
        JPanel panel0 = new JPanel();
        panel0.setLayout(null);
        panel0.setBounds(10,10,780,260); 
        panel0.setBackground(myColor1);
        String text01 = "Welcome to Aeki";
        String text02 =  "<br /><br />We offer a limited selection of furniture in a carefully selected style, featuring classic colors and high quality fabrics. Whether you are looking for a comfortable or a chic model, we have the perfect piece for you. The design used is timeless and fits perfectly into any home. Our furniture is made from sustainable materials and with great attention to detail, so you will enjoy your furniture for many years to come. With our excellent customer service and fast delivery, you can be sure that your purchase will be a pleasant experience. <br /> <br /> Thank you for choosing us!";       
        JLabel label01 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:30px'><font color='#C2DFFF'>"+text01+"</font></body></body></html>");
        JLabel label02 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:12px'><font color='#C2DFFF'>"+text02+"</font></body></body></html>");
        label01.setBounds(10, 10, 580, 40);
        label02.setBounds(10, 20, 760, 240);
        panel0.add(label01);
        panel0.add(label02);
        
        JLabel label03 = new JLabel();
        label03.setIcon(new ImageIcon("Picture0.jpg"));
        label03.setBounds(10, 280, 780, 460);
        panel0.add(label03);
        
        c1.add(panel0);
        c1.add(label03);
        homeFrame.add(c1);
    }
    
    /** 
    * @param set the the design and content of the catalogue frame
    */
    public void setUpCatalogueFrame(JFrame catalogueFrame)
    {
        //Panel frame 1
        c1.removeAll();
        c1 = getContentPane();
        
        JPanel panel20 = new JPanel();
        panel20.setLayout(null);
        panel20.setBounds(10,10,375,370);
        panel20.setBackground(myColor2);
        
        JPanel panel23 = new JPanel();
        panel23.setLayout(null);
        panel23.setBounds(10,390,375,350);
        panel23.setBackground(myColor2);
        
        JPanel panel21 = new JPanel();
        panel21.setLayout(null);
        panel21.setBounds(395,10,395,370);
        panel21.setBackground(myColor3);
        
        JLabel label21 = new JLabel();
        label21.setIcon(new ImageIcon("Picture1.png"));
        label21.setBounds(10, 10, 375, 160);
        panel21.add(label21);
        
        JLabel label22 = new JLabel();
        label22.setIcon(new ImageIcon("Picture2.png"));
        label22.setBounds(10, 180, 375, 180);
        panel21.add(label22);
        
        JPanel panel22 = new JPanel();
        panel22.setLayout(null);
        panel22.setBounds(395,390,395,350);
        panel22.setBackground(myColor3);
        
        JLabel label23 = new JLabel();
        label23.setIcon(new ImageIcon("Picture3.png"));
        label23.setBounds(60, 10, 375, 160);
        panel22.add(label23);
        
        JLabel label24 = new JLabel();
        label24.setIcon(new ImageIcon("Picture4.png"));
        label24.setBounds(120, 180, 375, 160);
        panel22.add(label24);
        
        String text01 = "Our Sofa";
        String text02 =  "Our leather sofa 'Anna' is the perfect blend of mid-century and chic design. The warm and inviting tones of this piece of furniture will make your guests feel right at home. It's tufted and well-trimmed, whilst the angular armrests and low profile add a dose of classic flair to this piece of high-quality leather seating in natural washed ebony.<br /><br />Price: 5190.-";       
        JLabel label01 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:24px'><font color='#0000A0'>"+text01+"</font></body></body></html>");
        JLabel label02 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text02+"</font></body></body></html>");
        label01.setBounds(10, 10, 355, 40);
        label02.setBounds(10, 20, 355, 240);
        
        String text03 = "Our Chair";
        String text04 =  "Our leather chair 'Tim' is the perfect blend of mid-century and chic design. The warm and inviting tones of this piece of furniture will make your guests feel right at home. It's tufted and well-trimmed, whilst the angular armrests and low profile add a dose of classic flair to this piece of high-quality leather seating in natural washed ebony.<br /><br />Price: 2890.-";       
        JLabel label03 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:24px'><font color='#0000A0'>"+text03+"</font></body></body></html>");
        JLabel label04 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text04+"</font></body></body></html>");
        label03.setBounds(10, 10, 355, 40);
        label04.setBounds(10, 20, 355, 240);
        
        panel20.add(label01);
        panel20.add(label02);
        panel23.add(label03);
        panel23.add(label04);
        
        c1.add(panel20);
        c1.add(panel21);
        c1.add(panel22);
        c1.add(panel23);
        catalogueFrame.add(c1);
    }
    
    /** 
    * @param set the the design and content of the order frame
    */
    public void setUpOrderFrame(JFrame orderFrame)
    {
        //Panel
        c1.removeAll();
        c1 = getContentPane();
        JPanel panel31 = new JPanel();
        panel31.setLayout(null);
        panel31.setBounds(10,10,780,260); 
        panel31.setBackground(myColor1);
        
        JPanel panel32 = new JPanel();
        panel32.setLayout(null);
        panel32.setBounds(10, 280, 780, 460); 
        panel32.setBackground(myColor2);
        
        //Labels
        String text31 = "Please enter you Order here";
        String text35 = "Please enter either a positive number in the number-field for chairs or for sofas or for both before sending order. To send an additional order please refresh the number-fields first.";
        String text32 = "Number of desired chairs:";
        String text33 = "Number of desired sofas:";
        JLabel welcomeLabel = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:24px'><font color='#C2DFFF'>"+text31+"</font></body></body></html>");
        welcomeLabel.setBounds(10, 10, 580, 40);
        JLabel descriptionLabel = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text35+"</font></body></body></html>");
        descriptionLabel.setBounds(10, 50, 760, 60);
        JLabel label_chairs = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text32+"</font></body></body></html>");
        label_chairs.setBounds(10,130,300,25);
        JLabel label_sofas = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text33+"</font></body></body></html>");
        label_sofas.setBounds(10,160,300,25);
        
        String text34 = "Order confirmation will appear here after successful registration."+"<br />"+"<br />"+"<br />"+"<br />"+"<br />";
        JLabel label_orderconfirmation1 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text34+"</font></body></body></html>");
        label_orderconfirmation1.setBounds(10,10,760,100);
        
        //Text Fields
        JTextField textfield_chairs = new JTextField();
        textfield_chairs.setBounds(300,130,90,25);
        JTextField textfield_sofas = new JTextField();
        textfield_sofas.setBounds(300,160,90,25);
        
        //Buttons
        JButton button_sendorder = new JButton("Send Order");
        button_sendorder.setBounds(10,205,150,30);
        button_sendorder.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) {
                if(textfield_sofas.getText().equals("")){textfield_sofas.setText("0");}
                if(textfield_chairs.getText().equals("")){textfield_chairs.setText("0");}
                factory1.createOrder(Integer.parseInt(textfield_sofas.getText()),Integer.parseInt(textfield_chairs.getText()));
                int orderNumber = factory1.orderNr;
                for (int i = 0; i < factory1.orders.size(); i++)
                {
                    if (factory1.orders.get(i).gibOrderNr() == orderNumber)
                    {
                        String text36 = "The order with the order number "+orderNumber+" was succesfully registered and contains the following information: "+"<br />"+
                                        "The number of chairs ordered amounts to: "+factory1.orders.get(i).gibAnzahlStuehle()+"<br />"+   
                                        "The number of sofas ordered amounts to: "+factory1.orders.get(i).gibAnzahlSofas()+"<br />"+
                                        "Furthermore, the procurement time for the required raw materials amounts to: "+factory1.orders.get(i).gibBeschaffungsZeit()+" days."+"<br />"+
                                        "If this is added to the production time, we receive the delivery time, which amounts to: "+factory1.orders.get(i).gibLieferZeit()+" days.";
                        label_orderconfirmation1.setText("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text36+"</font></body></body></html>");
                    }
                }
            }
        }
        );
        
        JButton button_refreshorder = new JButton("Refresh Order Fields");
        button_refreshorder.setBounds(190,205,200,30);
        button_refreshorder.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) {
                textfield_chairs.setText("");
                textfield_sofas.setText("");
                String text38 = "Order confirmation will appear here after successful registration."+"<br />"+"<br />"+"<br />"+"<br />"+"<br />";
                label_orderconfirmation1.setText("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text38+"</font></body></body></html>");
            }
        }
        );
        // Add to panel
        panel31.add(welcomeLabel);panel31.add(descriptionLabel);panel31.add(label_chairs);panel31.add(label_sofas);panel31.add(textfield_chairs);panel31.add(textfield_sofas);panel32.add(label_orderconfirmation1);panel31.add(button_sendorder);panel31.add(button_refreshorder);
        // Add to frame
        c1.add(panel31);
        c1.add(panel32);
        orderFrame.add(c1);
    }
    
    /** 
    * @param set the the design and content of the confirmation Frame
    */
    public void setUpConfiramtionFrame(JFrame confirmationFrame)
    {
        //Panel
        c1.removeAll();
        c1 = getContentPane();
        JPanel panel41 = new JPanel();
        panel41.setLayout(null);
        panel41.setBounds(10,10,780,260); 
        panel41.setBackground(myColor1);
        
        JPanel panel42 = new JPanel();
        panel42.setLayout(null);
        panel42.setBounds(10, 280, 780, 460); 
        panel42.setBackground(myColor2);
        
        //Labels
        String text41 = "Search for you Order Confirmation here";
        String text45 = "Please enter the number of your order in the number-field below. To look up an additional order confirmation please refresh the number-field first.";
        String text42 = "Look up order number:";
        JLabel welcomeLabel = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:24px'><font color='#C2DFFF'>"+text41+"</font></body></body></html>");
        welcomeLabel.setBounds(10, 10, 680, 40);
        JLabel descriptionLabel = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text45+"</font></body></body></html>");
        descriptionLabel.setBounds(10, 50, 760, 60);
        JLabel label_orderNr = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text42+"</font></body></body></html>");
        label_orderNr.setBounds(10,130,300,25);
        
        String text44 = "Order confirmation will appear here after successful search."+"<br />"+"<br />"+"<br />"+"<br />"+"<br />";
        JLabel label_orderconfirmation1 = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text44+"</font></body></body></html>");
        label_orderconfirmation1.setBounds(10,10,760,100);
        
        //Text Fields
        JTextField textfield_orderNr = new JTextField();
        textfield_orderNr.setBounds(300,130,90,25);
        
        //Buttons
        JButton button_orderNr = new JButton("Search confirmation");
        button_orderNr.setBounds(10,205,180,30);
        button_orderNr.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) {
                int orderNr = Integer.parseInt(textfield_orderNr.getText());
                for (int i = 0; i < factory1.orders.size(); i++)
                {
                    if (factory1.orders.get(i).gibOrderNr() == orderNr)
                    {
                        String text36 = "The order with the order number "+orderNr+" exists and was succesfully registered. It contains the following information: "+"<br />"+
                                        "The number of chairs ordered amounts to: "+factory1.orders.get(i).gibAnzahlStuehle()+"<br />"+
                                        "The number of sofas ordered amounts to: "+factory1.orders.get(i).gibAnzahlSofas()+"<br />"+   
                                        "Please be patient the order will be delivered as soon as possible."+"<br />";
                        label_orderconfirmation1.setText("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text36+"</font></body></body></html>");
                    }
                }
            }
        }
        );
        
        JButton button_refreshOrderNr = new JButton("Refresh OrderNR Field");
        button_refreshOrderNr.setBounds(190,205,200,30);
        button_refreshOrderNr.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) {
                textfield_orderNr.setText("");
                String text48 = "Order confirmation will appear here after successful search."+"<br />"+"<br />"+"<br />"+"<br />"+"<br />";
                label_orderconfirmation1.setText("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text48+"</font></body></body></html>");
            }
        }
        );
        
        // Add to panel
        panel41.add(welcomeLabel);panel41.add(descriptionLabel);panel41.add(label_orderNr);panel41.add(textfield_orderNr);panel42.add(label_orderconfirmation1);panel41.add(button_orderNr);panel41.add(button_refreshOrderNr);
        
        // Add to frame
        c1.add(panel41);
        c1.add(panel42);
        confirmationFrame.add(c1);
    }
    
    /** 
    * @param set the the design and content of the about frame
    */
    public void setUpAboutFrame(JFrame aboutFrame)
    {
        //Panel
        c1.removeAll();
        c1 = getContentPane();
        JPanel panel51 = new JPanel();
        panel51.setLayout(null);
        panel51.setBounds(10,10,780,260); 
        panel51.setBackground(myColor1);
        
        JPanel panel52 = new JPanel();
        panel52.setLayout(null);
        panel52.setBounds(10, 280, 780, 460); 
        panel52.setBackground(myColor2);
        
        //Labels
        String text51 = "About Us";
        String text52 = "We are young and innovative high end furniture producers. We focus on creating classic trendy pieces while maintaining the highest quality. We only use the best materials and have a team of experienced craftsmen to ensure that each piece is perfect. Our products are designed to last for years and will add a unique touch to any space. We are proud to offer a limited range of products that are sure to meet any expectation. <br /> <br /> We can be contacted via email: aeki@info.com or via phone: +410791221212.";
        JLabel aboutLabel = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:24px'><font color='#C2DFFF'>"+text51+"</font></body></body></html>");
        aboutLabel.setBounds(10, 10, 580, 40);
        JLabel about2Label = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#C2DFFF'>"+text52+"</font></body></body></html>");
        about2Label.setBounds(10, 60, 760, 120);
        
        JLabel label5 = new JLabel();
        label5.setIcon(new ImageIcon("Picture62.png"));
        label5.setBounds(10, 40, 760, 380);
        
        String text53 = "We are currently located in Zurich Seefeld. Our office is based at Höschgasse8, 8008 Zurich, Switzerland. We are open from Monday to Friday from 9am to 5pm.";
        JLabel about3Label = new JLabel("<html><body style='font-family:Century Gothic'><body style='font-size:11px'><font color='#0000A0'>"+text53+"</font></body></body></html>");
        about3Label.setBounds(10, 10, 760, 40);
        
        panel51.add(aboutLabel);panel51.add(about2Label);panel52.add(label5);panel52.add(about3Label);
        
        // Add to frame
        c1.add(panel51);
        c1.add(panel52);
        aboutFrame.add(c1);
    }
    
    /** 
    * @main Main method as entry point of the java application
    */
    public static void main(String [] args)
    {
        GUI gui1 = new GUI();
    }
    
}
