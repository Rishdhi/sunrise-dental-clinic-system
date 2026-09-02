/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hnd
 */
public class DBConnection {
     public static com.mysql.jdbc.Connection getConnection(){
         com.mysql.jdbc.Connection con = null;
         try {

            Class.forName(
            "com.mysql.jdbc.Driver");

            con =  (com.mysql.jdbc.Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost/sunrise_dental_clinic",
            "root", "");

            System.out.println("Database Connected");

        }
        catch(Exception e){

            System.out.println(e);

        }
        return con;
    }
}
