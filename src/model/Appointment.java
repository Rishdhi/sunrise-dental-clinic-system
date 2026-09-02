/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author Admin
 */
public class Appointment {
    
     private int appointmentNumber;
    private int patientId;
    private int dentistId;
    private int treatmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
 
    // Convenience fields for display (populated via JOIN queries, not stored directly)
    private String patientName;
    private String dentistName;
    private String treatmentName;
 
    public Appointment() {
    }
 
    public Appointment(int appointmentNumber, int patientId, int dentistId, int treatmentId,
            LocalDate appointmentDate, LocalTime appointmentTime) {
        this.appointmentNumber = appointmentNumber;
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.treatmentId = treatmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
 
    public Appointment(int patientId, int dentistId, int treatmentId,
            LocalDate appointmentDate, LocalTime appointmentTime) {
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.treatmentId = treatmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
 
    public int getAppointmentNumber() {
        return appointmentNumber;
    }
 
    public void setAppointmentNumber(int appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }
 
    public int getPatientId() {
        return patientId;
    }
 
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
 
    public int getDentistId() {
        return dentistId;
    }
 
    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }
 
    public int getTreatmentId() {
        return treatmentId;
    }
 
    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }
 
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
 
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
 
    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
 
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
 
    public String getPatientName() {
        return patientName;
    }
 
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
 
    public String getDentistName() {
        return dentistName;
    }
 
    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }
 
    public String getTreatmentName() {
        return treatmentName;
    }
 
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }
 
    @Override
    public String toString() {
        return "Appointment{" + "appointmentNumber=" + appointmentNumber
                + ", patientId=" + patientId + ", dentistId=" + dentistId
                + ", treatmentId=" + treatmentId + ", date=" + appointmentDate
                + ", time=" + appointmentTime + '}';
    }
    
}
