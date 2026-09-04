/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.BillController;
import model.AppointmentDetails;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Admin
 */
public class BillControllerTest {
    
    BillController controller = new BillController();

    // Test Case 1 – Load Existing Appointment
    @Test
    public void testGetAppointmentForBillingValid() {
        AppointmentDetails details = controller.getAppointmentForBilling("1");
        assertNotNull(details);
    }

    // Test Case 2 – Load Non-Existent Appointment Number
    @Test
    public void testGetAppointmentForBillingInvalidNumber() {
        AppointmentDetails details = controller.getAppointmentForBilling("999999");
        assertNull(details);
    }

    // Test Case 3 – Non-Numeric Appointment Number
    @Test
    public void testGetAppointmentForBillingNonNumeric() {
        AppointmentDetails details = controller.getAppointmentForBilling("abc");
        assertNull(details);
    }

    // Test Case 4 – Empty Appointment Number
    @Test
    public void testGetAppointmentForBillingEmpty() {
        AppointmentDetails details = controller.getAppointmentForBilling("");
        assertNull(details);
    }

    // Test Case 5 – Negative Consultation Fee Rejected
    @Test
    public void testNegativeConsultationFee() {
        String result = controller.generateBill(1, "Cleaning", -500);
        assertEquals("Consultation fee cannot be negative", result);
    }

    // Test Case 6 – Successful Bill Generation
    @Test
    public void testGenerateBillSuccess() {
        String result = controller.generateBill(1, "Cleaning", 500);
        assertTrue(result.startsWith("BILL_SAVED:"));
    }
    
}
