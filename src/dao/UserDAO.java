/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import com.mysql.jdbc.Connection;
import db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hnd
 */
public class UserDAO {
    
     public boolean authenticate(String username, String password) {

        String sql =
                "SELECT * FROM app_user WHERE username = ? AND password_hash = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());

            return false;
        }
    }
}
