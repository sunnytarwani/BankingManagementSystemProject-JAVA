package com.example.bankingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public  class Login extends JFrame implements ActionListener {
    JButton login , signup , clear;
    JTextField cardtext;
    JPasswordField pintext;
    JLabel pin , card , text;

    Login(){
        setTitle("Automated Teller Machine");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

        setLayout(null);
        //this is used to set the bg as white
        getContentPane().setBackground(Color.WHITE);


        //in the intelliJ we never use the "ClassLoader.getSystem.Resource"
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/logo.jpg"));
        ImageIcon i1 = new ImageIcon("src/icons/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);



        //JLabel label = new JLabel(i1); we were using this as we wanted to see our logo on the login page.
        //But now we have used i2 object, we're calling the image class and we can't use it directly in the JLabel
        //so, we'll create another ImageIcon object.
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10,10,100,100);


        //setBound func won't work until and unless you set the Border layout to null.
        //there is some border layout set by the system, which we need to set to null to make sude the changes are appearing.
        add(label);

        //now if we need something right next our logo we will again use the JLabel
        text = new JLabel("Welcome to ATM");
        //as we set the layout to null we need to give the
        text.setFont(new Font("Osward" , Font.BOLD , 38));
        text.setBounds(250,40,400,40);
        add(text);

        //To accept the card number
        card = new JLabel("Card No :");
        card.setFont(new Font("Osward" , Font.BOLD , 26));
        card.setBounds(120,150,200,40);
        add(card);

        cardtext = new JTextField();
        cardtext.setBounds(320,150,250,30);
        add(cardtext);

        //it will accept the pin no
        pin = new JLabel("Pin :");
        pin.setFont(new Font("Osward" , Font.BOLD , 26));
        pin.setBounds(120,220,300,40);
        add(pin);

        pintext = new JPasswordField();
        pintext.setBounds(320,220,250,30);
        add(pintext);

        login = new JButton("SIGN IN");
        login.setBounds(320 , 260 , 100 , 25);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        signup = new JButton("SIGN UP");
        signup.setBounds(440 , 260 , 100 , 25);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(320 , 300 , 200 , 25);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardtext.setText("");
            pintext.setText("");
        }
        else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardno = cardtext.getText();
            String pinno = pintext.getText();
            String query = "select * from login where card_no = '"+cardno+"' and pin_no = '"+pinno+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null , "Incorrect card number or pin!");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
