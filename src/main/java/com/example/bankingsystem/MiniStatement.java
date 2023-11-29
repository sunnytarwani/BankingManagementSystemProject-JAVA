package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinno;
    JLabel bank, card , balance;

    MiniStatement(String pinno){
        this.pinno = pinno;
        setSize(400 , 600);
        setLocation(20 , 20);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        JLabel mini =new JLabel();
        mini.setBounds(30 , 140 , 300 , 200 );
        add(mini);

        bank = new JLabel("ICICI Bank");
        bank.setBounds(150 , 20 , 100 , 30);
        add(bank);

        card = new JLabel();
        card.setBounds(30 , 80 , 300 , 20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20 , 450 , 300 , 20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_no = '"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("card_no").substring(0,4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            int bal = 0;
            Conn conn1 = new Conn();
            ResultSet rs1 = conn1.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            while(rs1.next()){
                mini.setText(mini.getText() +"<html>"+ rs1.getString("date")  + " " + rs1.getString("type") + " " +  rs1.getString("amount") +"<br><br><html>");
                if(rs1.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs1.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs1.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new MiniStatement(""));
    }
}

