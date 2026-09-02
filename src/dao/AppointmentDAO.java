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
public class AppointmentDAO {
    
public int saveAppointment(int patientId, int dentistId, String treatmentType,
                                String date, String time) {

        String sql =
                "INSERT INTO appointment (patient_id, dentist_id, treatment_type, appointment_date, appointment_time) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, patientId);
            pst.setInt(2, dentistId);
            pst.setString(3, treatmentType);
            pst.setString(4, date);
            pst.setString(5, time);

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
