/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.Connection;
import db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Dentist;
import db.DBConnection;
import java.sql.*;
import java.util.*;
import model.Dentist;
/**
 *
 * @author Admin
 */
public class DentistDAO {
    
    public List<Dentist> getAllDentists() {
        List<Dentist> list = new ArrayList<>();
        String sql = "SELECT dentist_id, name FROM dentist";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Dentist d = new Dentist();
                d.setDentistId(rs.getInt("dentist_id"));
                d.setName(rs.getString("name"));
                list.add(d);
            }
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return list;
    }
    
}
