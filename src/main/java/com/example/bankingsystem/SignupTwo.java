package com.example.bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JLabel additionalDetails , religiond , category,  income_d , edu , quali , occu , pan , aad_no , sc , ea;
    JTextField   aad_tf  , pantf;
    JComboBox  religiontf , categorytf , incometf , edutf , quatf , occtf;
    JRadioButton  syes , sno , eyes , eno;
    JButton next;
    String formno;


    SignupTwo(String formno){

        this.formno = formno;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setSize(850 , 800);
        setLocation(350 , 10);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2:");

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 20));
        additionalDetails.setBounds(255 ,55 , 400 , 40);
        add(additionalDetails);

        religiond = new JLabel("RELIGION:");
        religiond.setFont(new Font("Raleway" , Font.BOLD , 25));
        religiond.setBounds(60 ,140 , 130 , 35);
        add(religiond);

        String [] val_reli = {"Hindu" , "Muslim" , "Christian" , "Sikh" , "Other"};
        religiontf = new JComboBox(val_reli);
        religiontf.setBounds(325 , 140 , 400 , 25);
        religiontf.setBackground(Color.WHITE);
        add(religiontf);



        category = new JLabel("CATEGORY:");
        category.setFont(new Font("Raleway" , Font.BOLD , 25));
        category.setBounds(60 ,190 , 300 , 35);
        add(category);

        String [] val_cat = {"General" , "SC" , "ST" , "OBC" , "Other"};
        categorytf = new JComboBox(val_cat);
        categorytf.setBounds(325 , 190 , 400 , 25);
        categorytf.setBackground(Color.WHITE);
        add(categorytf);



        income_d = new JLabel("INCOME:");
        income_d.setFont(new Font("Raleway" , Font.BOLD , 25));
        income_d.setBounds(60 ,240 , 450 , 35);
        add(income_d);

        String [] val_inc = {"NULL" , "< 1,50,000" , "<5,00,000" , "<10,00,000" , ">15,00,000"};
        incometf = new JComboBox(val_inc);
        incometf.setBounds(325 , 240 , 400 , 25);
        incometf.setBackground(Color.WHITE);
        add(incometf);


        edu = new JLabel("EDUCATIONAL:");
        edu.setFont(new Font("Raleway" , Font.BOLD , 25));
        edu.setBounds(60 ,290 , 200 , 35);
        add(edu);

        String [] val_edu = {"Graduate" , "Under-Graduate" , "Post-Graduate" , "PHD" , "Other"};
        edutf = new JComboBox(val_edu);
        edutf.setBounds(325 , 290 , 400 , 25);
        edutf.setBackground(Color.WHITE);
        add(edutf);


        quali = new JLabel("QUALIFICATION:");
        quali.setFont(new Font("Raleway" , Font.BOLD , 25));
        quali.setBounds(60 ,340 , 200 , 35);
        add(quali);

        String [] val_qua = {"Salaried" , "Self-employeed" , "Retired" , "Other"};
        quatf = new JComboBox(val_qua);
        quatf.setBounds(325 , 340 , 400 , 25);
        quatf.setBackground(Color.WHITE);
        add(quatf);


        occu = new JLabel("OCCUPATION:");
        occu.setFont(new Font("Raleway" , Font.BOLD , 25));
        occu.setBounds(60 ,390 , 300 , 35);
        add(occu);

        String [] val_occ = {"Engineer" , "Doctor" , "CA" , "Government" , "Other"};
        occtf = new JComboBox(val_occ);
        occtf.setBounds(325 , 390 , 400 , 25);
        occtf.setBackground(Color.WHITE);
        add(occtf);

        pan = new JLabel("PAN-NO :");
        pan.setFont(new Font("Raleway" , Font.BOLD , 25));
        pan.setBounds(60 ,440 , 150 , 35);
        add(pan);

        pantf = new JTextField();
        pantf.setFont(new Font("Raleway" , Font.PLAIN, 17));
        pantf.setBounds(325 , 440 , 400 , 25);
        add(pantf);



        aad_no = new JLabel("AADHAR_No :");
        aad_no.setFont(new Font("Raleway" , Font.BOLD , 25));
        aad_no.setBounds(60 ,490 , 250 , 35);
        add(aad_no);

        aad_tf = new JTextField();
        aad_tf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        aad_tf.setBounds(325 , 490 , 400 , 25);
        add(aad_tf);




        sc = new JLabel("SENIOR_CITIZEN :");
        sc.setFont(new Font("Raleway" , Font.BOLD , 25));
        sc.setBounds(60 ,540 , 300 , 35);
        add(sc);

        syes = new JRadioButton("YES");
        syes.setBounds(325 , 540 , 100 , 25);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(430 , 540 , 100 , 25);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sc_g = new ButtonGroup();
        sc_g.add(syes);
        sc_g.add(sno);



        ea = new JLabel("EXISTING_ACC:");
        ea.setFont(new Font("Raleway" , Font.BOLD , 25));
        ea.setBounds(60 ,590 , 300 , 35);
        add(ea);

        eyes = new JRadioButton("YES");
        eyes.setBounds(325 , 590 , 100 , 25);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(430 , 590 , 100 , 25);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup ea_g = new ButtonGroup();
        ea_g.add(eyes);
        ea_g.add(eno);




        next = new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway" , Font.BOLD , 16));
        next.setBounds(540 , 630 , 100 , 30);
        next.addActionListener(this);
        add(next);

    }
    public void actionPerformed(ActionEvent ae){
        String formno = this.formno;
        String religion_s = (String) religiontf.getSelectedItem();
        String category_s = (String) categorytf.getSelectedItem();
        String income_s = (String) incometf.getSelectedItem();
        String edu_s = (String) edutf.getSelectedItem();
        String occ_s = (String) occtf.getSelectedItem();
        String sc_s = null;
        if(syes.isSelected()){
            sc_s = "YES";
        }
        else if (sno.isSelected()){
            sc_s = "Female";
        }

        String ea_s = null;
        if(eyes.isSelected()){
            ea_s = "YES";
        }
        else if(eno.isSelected()){
            ea_s = "NO";
        }

        String pan = pantf.getText();
        String aadhar = aad_tf.getText();

        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values ('"+formno+"' , '"+religion_s+"' , '"+category_s+"' ,'"+income_s+"' , '"+edu_s+"' , '"+occ_s+"' , '"+pan+"'  , '"+aadhar+"'  , '"+sc_s+"'  , '"+ea_s+"' )";
            c.s.executeUpdate(query);


            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new SignupTwo(""));
    }
}
