/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TreatmentDAO {
    
        public List<String> getAllTreatmentTypes() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT treatment_type FROM treatment";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getString("treatment_type"));
            }

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return list;
    }
    
}
