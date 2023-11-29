package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinno;
    JButton back;
    BalanceEnquiry(String pinno){
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

        back = new JButton("BACK");
        back.setBounds(240 , 400 , 90 , 18);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinno + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current account balance is Rs - " +balance);
        text.setForeground(Color.white);
        text.setBounds(130 , 240 , 700 , 25);
        image.add(text);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinno).setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new BalanceEnquiry(""));
    }
}
