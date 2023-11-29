package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class Fastcash extends JFrame implements ActionListener {
    JButton hundred, five_hun, thousand, two_thou, five_thou, ten_thou, back;
    String pinno;
    Fastcash(String pinno){
        this.pinno = pinno;
        setSize(900 , 900);
        setLocation(300 , 0);
        setVisible(true);
        setLayout(null);
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,0,700,700);
        add(image);


        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT:");
        text.setBounds(130 , 200 , 700 , 25);
        text.setForeground(Color.white);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(90 , 320 , 110 , 25);
        hundred.addActionListener(this);
        image.add(hundred);

        five_hun = new JButton("Rs 500");
        five_hun.setBounds(275 , 320 , 130 , 25);
        five_hun.addActionListener(this);
        image.add(five_hun);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(90 , 350 , 110 , 25);
        thousand.addActionListener(this);
        image.add(thousand);

        two_thou = new JButton("Rs 2000");
        two_thou.setBounds(275 , 350 , 130 , 25);
        two_thou.addActionListener(this);
        image.add(two_thou);

        five_thou = new JButton("Rs 5000");
        five_thou.setBounds(90 , 380 , 110 , 25);
        five_thou.addActionListener(this);
        image.add(five_thou);

        ten_thou = new JButton("Rs 10,000");
        ten_thou.setBounds(275 , 380 , 130 , 25);
        ten_thou.addActionListener(this);
        image.add(ten_thou);

        back = new JButton("BACK");
        back.setBounds(275 , 410 , 130 , 25);
        back.addActionListener(this);
        image.add(back);

    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
        else{
           String amount = ((JButton)ae.getSource()).getText().substring(3);
           Conn c = new Conn();
           try {
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '" +pinno+"'");
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }

               if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null , "Insufficient Balance");
                   return;
               }

               Date date = new Date();
               String query = "insert into bank values('"+pinno+"' , '"+date+"' , 'Withdraw' , '"+amount+"' )";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null , "Rs "+ amount + " Debited Successfully");


               setVisible(false);
               new Transaction(pinno).setVisible(true);
           }catch (Exception e){
               System.out.println(e);
           }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Fastcash(""));
    }
}
