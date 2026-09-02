/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AppointmentDAO;
import dao.TreatmentDAO;
import dao.BillDAO;
import model.AppointmentDetails;

/**
 *
 * @author Admin
 */
public class BillController {
    
    private AppointmentDAO appointmentDAO;
    private TreatmentDAO treatmentDAO;
    private BillDAO billDAO;

    public BillController() {
        appointmentDAO = new AppointmentDAO();
        treatmentDAO = new TreatmentDAO();
        billDAO = new BillDAO();
    }

    // Fetch appointment details for billing
    public AppointmentDetails getAppointmentForBilling(String appointmentNumberStr) {

        if (appointmentNumberStr == null || appointmentNumberStr.trim().isEmpty()) {
            return null;
        }

        int appointmentNumber;

        try {
            appointmentNumber = Integer.parseInt(appointmentNumberStr.trim());
        } catch (NumberFormatException e) {
            return null;
        }

        return appointmentDAO.getAppointmentByNumber(appointmentNumber);
    }

    // Calculate and save the bill
    public String generateBill(int appointmentNumber, String treatmentType, double consultationFee) {

        if (consultationFee < 0) {
            return "Consultation fee cannot be negative";
        }

        double treatmentFee = treatmentDAO.getFeeByTreatmentType(treatmentType);

        double totalAmount = consultationFee + treatmentFee;

        int billId = billDAO.saveBill(appointmentNumber, consultationFee, treatmentFee, totalAmount);

        if (billId == -1) {
            return "Failed to save bill";
        }

        return "BILL_SAVED:" + billId + ":" + treatmentFee + ":" + totalAmount;
    }

    
    
}
