package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Transaction extends JFrame implements ActionListener {
    JButton deposit , withdrawal , fastcash , ministat , pinchange , balenq , exit;
    String pinno;
    Transaction(String pinno){
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


        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(130 , 200 , 700 , 25);
        text.setForeground(Color.white);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(90 , 320 , 110 , 25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(275 , 320 , 130 , 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fastcash");
        fastcash.setBounds(90 , 350 , 110 , 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministat = new JButton("Mini-Statment");
        ministat.setBounds(275 , 350 , 130 , 25);
        ministat.addActionListener(this);
        image.add(ministat);

        pinchange = new JButton("PINCHANGE");
        pinchange.setBounds(90 , 380 , 110 , 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balenq = new JButton("Balance_Enquiry");
        balenq.setBounds(275 , 380 , 130 , 25);
        balenq.addActionListener(this);
        image.add(balenq);

        exit = new JButton("EXIT");
        exit.setBounds(275 , 410 , 130 , 25);
        exit.addActionListener(this);
        image.add(exit);

    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }
        else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinno).setVisible(true);
        }
        else if(ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        }
        else if(ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinno).setVisible(true);
        }
        else if (ae.getSource() == balenq){
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        }
        else if(ae.getSource() == ministat){
            new MiniStatement(pinno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Transaction(""));
    }
}
