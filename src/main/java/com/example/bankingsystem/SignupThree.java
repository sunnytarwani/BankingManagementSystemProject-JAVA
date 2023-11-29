package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1 , r2 ,r3 ,r4;
    JCheckBox c1 , c2 , c3 , c4, c5, c6, c7;

    JButton submit , cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        setSize(800 , 900);
        setLocation(350 , 10);
        setLayout(null);
        setVisible(true);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway" , Font.BOLD , 22));
        l1.setBounds(280 , 40 , 400 , 40 );
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway" , Font.BOLD , 22));
        type.setBounds(100 , 140 , 200 , 30 );
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway" , Font.BOLD , 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100 , 180 , 300 , 20 );
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway" , Font.BOLD , 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400 , 180 , 350 , 20 );
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway" , Font.BOLD , 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100 , 220 , 300 , 20 );
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway" , Font.BOLD , 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400 , 220 , 350 , 20 );
        add(r4);

        ButtonGroup ga = new ButtonGroup();
        ga.add(r1);
        ga.add(r2);
        ga.add(r3);
        ga.add(r4);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway" , Font.BOLD , 22));
        card.setBounds(100 , 300 , 200 , 30 );
        add(card);

        JLabel number_c = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number_c.setFont(new Font("Raleway" , Font.BOLD , 22));
        number_c.setBounds(330 , 300 , 350 , 30 );
        add(number_c);

        JLabel details = new JLabel("This is your Card Number");
        details.setFont(new Font("Raleway" , Font.BOLD , 12));
        details.setBounds(100 , 330 , 200 , 20 );
        add(details);


        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway" , Font.BOLD , 22));
        pin.setBounds(100 , 360 , 200 , 30 );
        add(pin);

        JLabel pin_no = new JLabel("XXXX");
        pin_no.setFont(new Font("Raleway" , Font.BOLD , 22));
        pin_no.setBounds(330 , 360 , 200 , 30 );
        add(pin_no);

        JLabel pindetails = new JLabel("This is your 4 DIGIT Password");
        pindetails.setFont(new Font("Raleway" , Font.BOLD , 12));
        pindetails.setBounds(100 , 390 , 200 , 20 );
        add(pindetails);

        JLabel label = new JLabel("Services Required:");
        label.setFont(new Font("Raleway" , Font.BOLD , 14));
        label.setBounds(100 , 410 , 200 , 20 );
        add(label);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway" , Font.BOLD , 20));
        c1.setBounds(100 , 430 , 200 , 30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway" , Font.BOLD , 20));
        c2.setBounds(450 , 430 , 350 , 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway" , Font.BOLD , 20));
        c3.setBounds(100 , 470 , 350 , 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway" , Font.BOLD , 20));
        c4.setBounds(450 , 470 , 350 , 30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway" , Font.BOLD , 20));
        c5.setBounds(100 , 520 , 350 , 30);
        add(c5);

        c6 = new JCheckBox("E-STATMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway" , Font.BOLD , 20));
        c6.setBounds(450 , 520 , 350 , 30);
        add(c6);

        c7 = new JCheckBox("I HERE BY DECLARE THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway" , Font.BOLD , 10));
        c7.setBounds(100 , 570 , 650 , 30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway" , Font.BOLD , 14));
        submit.setBounds(350 , 610 , 100 , 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway" , Font.BOLD , 14));
        cancel.setBounds(480 , 610 , 100 , 30);
        cancel.addActionListener(this);
        add(cancel);
    }

    public  void actionPerformed(ActionEvent ae ){

        String formno = this.formno;

        if(ae.getSource() == submit){
            String acc_type = null;
            if(r1.isSelected()){
                acc_type = "Saving Account";
            }
            else if (r2.isSelected()){
                acc_type = "Fixed Deposit Account";
            }
            else if (r3.isSelected()){
                acc_type = "Current Account";
            }
            else if (r4.isSelected()){
                acc_type = "Recurring Deposit Account";
            }

            Random random = new Random();
            String card_no =  "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin_no = "" + Math.abs((random.nextLong() & 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM CARD";
            }
            else if(c2.isSelected()){
                facility = facility + " INTERNET BANKING";
            }
            else if(c3.isSelected()){
                facility = facility + " MOBILE BANKING";
            }
            else if(c4.isSelected()){
                facility = facility + " EMAIL & SMS ALERTS";
            }
            else if(c5.isSelected()){
                facility = facility + " CHEQUE BOOK";
            }
            else if(c6.isSelected()){
                facility = facility + " E-STATEMENT";
            }

            try{
                if(acc_type.equals("")){
                    JOptionPane.showMessageDialog(null , "ACCOUNT TYPE REQUIRED");
                }
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null ,"Tick the Check Box ");
                }
                else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"' , '"+acc_type+"' , '"+card_no+"' , '"+pin_no+"' , '"+facility+"' )";
                    String query2 = "insert into login values('"+formno+"' ,'"+card_no+"' , '"+pin_no+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null ,"Card Number" + card_no + " \n PIN : " + pin_no);

                    setVisible(false);
                    new Deposit(pin_no).setVisible(true);
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new SignupThree(""));
    }
}
