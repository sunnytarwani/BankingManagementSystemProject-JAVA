package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawal , back;

    String pinno;
    Withdrawal(String pinno){
        this.pinno = pinno;
        setSize(900 , 900);
        setLayout(null);
        setVisible(true);
        setLocation(300 , 0);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800 , 800 , Image.SCALE_DEFAULT );

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,0,700,700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        text.setBounds(110 , 200 , 700 , 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway" , Font.BOLD , 22));
        amount.setBounds(90 , 235 , 320 , 25);
        image.add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(255 , 365 , 150 , 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(255 , 400 , 150 , 30);
        back.addActionListener(this);
        image.add(back);



    }

    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdrawal){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null , "Please enter the amount you want to Withdraw");

            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinno+"' , '"+date+"' , '"+withdrawal.getText()+"' , '"+number+"') ";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null , "Withdrawal of Rs, "+number+ " successfully from your bank account");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }


            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Withdrawal(""));
    }
}
