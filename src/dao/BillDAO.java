/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.Connection;
import db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class BillDAO {
    
    public int saveBill(int appointmentNumber, double consultationFee,
                         double treatmentFee, double totalAmount) {

        String sql =
                "INSERT INTO bill (appointment_number, consultation_fee, treatment_fee, total_amount) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, appointmentNumber);
            pst.setDouble(2, consultationFee);
            pst.setDouble(3, treatmentFee);
            pst.setDouble(4, totalAmount);

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
