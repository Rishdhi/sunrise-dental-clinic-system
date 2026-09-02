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

public model.AppointmentDetails getAppointmentByNumber(int appointmentNumber) {

    String sql =
            "SELECT a.appointment_number, p.name, p.address, p.contact_number, "
            + "d.name AS dentist_name, a.treatment_type, a.appointment_date, a.appointment_time "
            + "FROM appointment a "
            + "JOIN patient p ON a.patient_id = p.patient_id "
            + "JOIN dentist d ON a.dentist_id = d.dentist_id "
            + "WHERE a.appointment_number = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, appointmentNumber);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            model.AppointmentDetails details = new model.AppointmentDetails();

            details.setAppointmentNumber(rs.getInt("appointment_number"));
            details.setPatientName(rs.getString("name"));
            details.setAddress(rs.getString("address"));
            details.setContactNumber(rs.getString("contact_number"));
            details.setDentistName(rs.getString("dentist_name"));
            details.setTreatmentType(rs.getString("treatment_type"));
            details.setAppointmentDate(rs.getString("appointment_date"));
            details.setAppointmentTime(rs.getString("appointment_time"));

            return details;
        }

    } catch (Exception e) {

        System.out.println("Database Error: " + e.getMessage());
    }

    return null;
}

    
}
