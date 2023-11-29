package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    JLabel formno , personalDetails , namedetails , fathername,  dob , gender , email , martial , address , city , state , pin;
    JTextField nametf , fnametf , emailtf , addresstf , citytf , statetf , pintf , calendar;
    JRadioButton male , female , married , unmar , other;
    JButton next;
    long random;



    SignupOne(){
        Random rm = new Random();
        random = (Math.abs(rm.nextLong() % 9000L)+1000L);


        formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Raleway" , Font.BOLD , 30));
        formno.setBounds(140 ,20 , 600 , 50);
        add(formno);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway" , Font.BOLD , 20));
        personalDetails.setBounds(210 ,65 , 400 , 25);
        add(personalDetails);

        namedetails = new JLabel("NAME:");
        namedetails.setFont(new Font("Raleway" , Font.BOLD , 25));
        namedetails.setBounds(60 ,140 , 100 , 35);
        add(namedetails);

        nametf = new JTextField();
        nametf.setFont(new Font("Raleway" , Font.PLAIN ,17));
        nametf.setBounds(325 , 140 , 400 , 25);
        add(nametf);

        fathername = new JLabel("FATHER'S NAME:");
        fathername.setFont(new Font("Raleway" , Font.BOLD , 25));
        fathername.setBounds(60 ,190 , 300 , 35);
        add(fathername);

        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway" , Font.PLAIN, 17));
        fnametf.setBounds(325 , 190 , 400 , 25);
        add(fnametf);

        dob = new JLabel("DOB(DD-MM-YEAR):");
        dob.setFont(new Font("Raleway" , Font.BOLD , 25));
        dob.setBounds(60 ,240 , 450 , 35);
        add(dob);

        calendar = new JTextField();
        calendar.setFont(new Font("Raleway" , Font.PLAIN, 17));
        calendar.setBounds(325 , 240 , 400 , 25);
        add(calendar);


        gender = new JLabel("GENDER:");
        gender.setFont(new Font("Raleway" , Font.BOLD , 25));
        gender.setBounds(60 ,290 , 200 , 35);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(325 , 290 , 60 , 25);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("FEMALE");
        female.setBounds(420 , 290 , 80 , 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderg = new ButtonGroup();
        genderg.add(male);
        genderg.add(female);

        email = new JLabel("EMAIL ID:");
        email.setFont(new Font("Raleway" , Font.BOLD , 25));
        email.setBounds(60 ,340 , 200 , 35);
        add(email);

        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        emailtf.setBounds(325 , 340 , 400 , 25);
        add(emailtf);

        martial = new JLabel("MARTIAL STATUS :");
        martial.setFont(new Font("Raleway" , Font.BOLD , 25));
        martial.setBounds(60 ,390 , 300 , 35);
        add(martial);

        married = new JRadioButton("MARRIED");
        married.setBounds(325 , 390 , 100 , 25);
        married.setBackground(Color.WHITE);
        add(married);
        unmar = new JRadioButton("UNMARRIED");
        unmar.setBounds(430 , 390 , 100 , 25);
        unmar.setBackground(Color.WHITE);
        add(unmar);
        other = new JRadioButton("OTHER");
        other.setBounds(540 , 390 , 100 , 25);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marriageg = new ButtonGroup();
        marriageg.add(married);
        marriageg.add(unmar);
        marriageg.add(other);

        address = new JLabel("ADDRESS :");
        address.setFont(new Font("Raleway" , Font.BOLD , 25));
        address.setBounds(60 ,440 , 150 , 35);
        add(address);

        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway" , Font.PLAIN, 17));
        addresstf.setBounds(325 , 440 , 400 , 25);
        add(addresstf);

        city = new JLabel("CITY :");
        city.setFont(new Font("Raleway" , Font.BOLD , 25));
        city.setBounds(60 ,490 , 100 , 35);
        add(city);

        citytf = new JTextField();
        citytf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        citytf.setBounds(325 , 490 , 400 , 25);
        add(citytf);

        state = new JLabel("STATE :");
        state.setFont(new Font("Raleway" , Font.BOLD , 25));
        state.setBounds(60 ,540 , 100 , 35);
        add(state);

        statetf = new JTextField();
        statetf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        statetf.setBounds(325 , 540 , 400 , 25);
        add(statetf);

        pin = new JLabel("PIN CODE :");
        pin.setFont(new Font("Raleway" , Font.BOLD , 25));
        pin.setBounds(60 ,590 , 200 , 35);
        add(pin);

        pintf = new JTextField();
        pintf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        pintf.setBounds(325 , 590 , 400 , 25);
        add(pintf);

        next = new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway" , Font.BOLD , 16));
        next.setBounds(540 , 630 , 100 , 30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setSize(850 , 800);
        setLocation(350 , 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nametf.getText();
        String fname = fnametf.getText();
        String db = calendar.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }

        String email = emailtf.getText();
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        }
        else if(unmar.isSelected()){
            martial = "Unmarried";
        }
        else if (other.isSelected()){
            martial = "Other";
        }

        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pin = pintf.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null , "Name is Required");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null , "Father's Name is Required");
            }
            else if(db.equals("")){
                JOptionPane.showMessageDialog(null , "DOB is Required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null , "Email is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"' , '"+name+"' , '"+fname+"' ,'"+db+"' , '"+gender+"' , '"+email+"' , '"+martial+"'  , '"+address+"'  , '"+city+"'  , '"+pin+"'  , '"+state+"' )";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        new SignupOne();
    }
}
