package com.example.bankingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
1. Register the Driver
2. Create Connection
3. Create Statement
4. Execute Query
5. Close Connection

we will create the object and use it no need for psvm
Mysql is an extended entity, we won't get compile error but runtime error
so we need a exception class for that error.

 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root" );
            s = c.createStatement();



        } catch (Exception e){
            System.out.println(e);
        }
    }
}

