package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {

    String pinno;

    JPasswordField pin1, pin_new1;
    JButton change , back;
    Pinchange(String pinno){
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

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(170 , 200 , 700 , 25);
        text.setForeground(Color.white);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text);

        JLabel pin = new JLabel("New PIN:");
        pin.setBounds(110 , 260 , 700 , 15);
        pin.setForeground(Color.white);
        pin.setFont(new Font("System" , Font.BOLD , 12));
        image.add(pin);

        pin1 = new JPasswordField();
        pin1.setBounds(240 , 260 , 150 , 15);
        pin1.setFont(new Font("Raleway" , Font.BOLD , 12));
        image.add(pin1);

        JLabel pin_new = new JLabel("Renter your new PIN:");
        pin_new.setBounds(110 , 290 , 700 , 15);
        pin_new.setForeground(Color.white);
        pin_new.setFont(new Font("System" , Font.BOLD , 12));
        image.add(pin_new);

        pin_new1 = new JPasswordField();
        pin_new1.setBounds(240 , 290 , 150 , 15);
        pin_new1.setFont(new Font("Raleway" , Font.BOLD , 12));
        image.add(pin_new1);

        change = new JButton("CHANGE");
        change.setBounds(130 , 400 , 90 , 18);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(240 , 400 , 90 , 18);
        back.addActionListener(this);
        image.add(back);

    }
    public void actionPerformed(ActionEvent ae){


        if(ae.getSource() == change){
            try {
                String npin = pin1.getText();
                String npin1 = pin_new1.getText();

                if(!npin1.equals(npin)){
                    JOptionPane.showMessageDialog(null , "ENTERED PIN DOESN'T MATCH");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null , "PLEASE ENTER A PIN");
                    return;
                }

                if(npin1.equals("")){
                    JOptionPane.showMessageDialog(null , "PLEASE RE-ENTER A NEW PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+npin1+"' where pin='"+pinno+"'";
                String query2 = "update login set pin_no = '"+npin1+"' where pin_no='"+pinno+"'";
                String query3 = "update signupthree set pin_no = '"+npin1+"' where pin_no='"+pinno+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null , "PIN changed successfully");

                setVisible(false);
                new Transaction(npin1).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Pinchange(""));
    }

}
