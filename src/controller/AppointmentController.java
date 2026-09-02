/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PatientDAO;
import dao.AppointmentDAO;

/**
 *
 * @author Admin
 */
public class AppointmentController {
    
    private PatientDAO patientDAO;
    private AppointmentDAO appointmentDAO;

    public AppointmentController() {
        patientDAO = new PatientDAO();
        appointmentDAO = new AppointmentDAO();
    }

    // Validation method
    public String validateInput(String name, String address, String contact,
                                 String date, String time) {

        if (name == null || name.trim().isEmpty()) {
            return "Patient name is required";
        }
        if (address == null || address.trim().isEmpty()) {
            return "Address is required";
        }
        if (contact == null || contact.trim().isEmpty()) {
            return "Contact number is required";
        }
        if (date == null || date.trim().isEmpty()) {
            return "Appointment date is required";
        }
        if (time == null || time.trim().isEmpty()) {
            return "Appointment time is required";
        }
        return "VALID";
    }

    // Save appointment method
    public String saveAppointment(String name, String address, String contact,
                                   int dentistId, String treatment,
                                   String date, String time) {

        String validationResult =
                validateInput(name, address, contact, date, time);

        if (!validationResult.equals("VALID")) {
            return validationResult;
        }

        int patientId = patientDAO.savePatient(name, address, contact);

        if (patientId == -1) {
            return "Failed to save patient details";
        }

        int appointmentNumber =
                appointmentDAO.saveAppointment(patientId, dentistId, treatment, date, time);

        if (appointmentNumber == -1) {
            return "Failed to save appointment";
        }

        return "APPOINTMENT_SAVED:" + appointmentNumber;
    }
    
}
