/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.*;
 import com.mysql.jdbc.Connection;
/**
 *
 * @author Admin
 */
public class PatientDAO {
    
 public int savePatient(String name, String address, String contact) {

        String sql =
                "INSERT INTO patient (name, address, contact_number) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, contact);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());
        }

        return -1;
    }
}
