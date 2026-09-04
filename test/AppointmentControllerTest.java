/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.AppointmentController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author Admin
 */
public class AppointmentControllerTest {
    
    AppointmentController controller = new AppointmentController();

    // Test Case 1 – Valid Input Passes Validation
    @Test
    public void testValidInput() {
        String result =
                controller.validateInput("Peter", "Colombo", "0771234567", "2026-09-10", "10:00:00");
        assertEquals("VALID", result);
    }

    // Test Case 2 – Empty Patient Name
    @Test
    public void testEmptyName() {
        String result =
                controller.validateInput("", "Colombo", "0771234567", "2026-09-10", "10:00:00");
        assertEquals("Patient name is required", result);
    }

    // Test Case 3 – Empty Address
    @Test
    public void testEmptyAddress() {
        String result =
                controller.validateInput("Peter", "", "0771234567", "2026-09-10", "10:00:00");
        assertEquals("Address is required", result);
    }

    // Test Case 4 – Empty Contact Number
    @Test
    public void testEmptyContact() {
        String result =
                controller.validateInput("Peter", "Colombo", "", "2026-09-10", "10:00:00");
        assertEquals("Contact number is required", result);
    }

    // Test Case 5 – Empty Date
    @Test
    public void testEmptyDate() {
        String result =
                controller.validateInput("Peter", "Colombo", "0771234567", "", "10:00:00");
        assertEquals("Appointment date is required", result);
    }

    // Test Case 6 – Empty Time
    @Test
    public void testEmptyTime() {
        String result =
                controller.validateInput("Peter", "Colombo", "0771234567", "2026-09-10", "");
        assertEquals("Appointment time is required", result);
    }

    // Test Case 7 – Successful Appointment Save
    @Test
    public void testSaveAppointmentSuccess() {
        String result = controller.saveAppointment(
                "Test Patient", "Test Address", "0770000000",
                1, "Cleaning", "2026-09-15", "09:00:00");
        assertTrue(result.startsWith("APPOINTMENT_SAVED:"));
    }

    // Test Case 8 – Save Rejected When Name Missing
    @Test
    public void testSaveAppointmentEmptyName() {
        String result = controller.saveAppointment(
                "", "Test Address", "0770000000",
                1, "Cleaning", "2026-09-15", "09:00:00");
        assertEquals("Patient name is required", result);
    }
    
}
