/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.AppointmentController;

/**
 *
 * @author Admin
 */
public class AppointmentTestRunner {
    
      static int totalTests = 0;
    static int passedTests = 0;

    public static void main(String[] args) {

        AppointmentController controller = new AppointmentController();

        System.out.println("======================================");
        System.out.println("     AUTOMATED APPOINTMENT TESTING");
        System.out.println("======================================");

        runTest(
                "Valid Input",
                controller.validateInput("Peter", "Colombo", "0771234567", "2026-09-10", "10:00:00"),
                "VALID"
        );

        runTest(
                "Empty Name",
                controller.validateInput("", "Colombo", "0771234567", "2026-09-10", "10:00:00"),
                "Patient name is required"
        );

        runTest(
                "Empty Address",
                controller.validateInput("Peter", "", "0771234567", "2026-09-10", "10:00:00"),
                "Address is required"
        );

        runTest(
                "Empty Contact",
                controller.validateInput("Peter", "Colombo", "", "2026-09-10", "10:00:00"),
                "Contact number is required"
        );

        runTest(
                "Empty Date",
                controller.validateInput("Peter", "Colombo", "0771234567", "", "10:00:00"),
                "Appointment date is required"
        );

        runTest(
                "Empty Time",
                controller.validateInput("Peter", "Colombo", "0771234567", "2026-09-10", ""),
                "Appointment time is required"
        );

        // saveAppointment returns a dynamic appointment number, so check the prefix instead of exact match
        String saveResult = controller.saveAppointment(
                "Test Patient", "Test Address", "0770000000",
                1, "Cleaning", "2026-09-15", "09:00:00");
        runPrefixTest("Save Appointment Success", saveResult, "APPOINTMENT_SAVED:");

        runTest(
                "Save Appointment Empty Name",
                controller.saveAppointment("", "Test Address", "0770000000", 1, "Cleaning", "2026-09-15", "09:00:00"),
                "Patient name is required"
        );

        System.out.println();
        System.out.println("======================================");
        System.out.println("              SUMMARY");
        System.out.println("======================================");
        System.out.println("Total Tests  : " + totalTests);
        System.out.println("Passed Tests : " + passedTests);
        System.out.println("Failed Tests : " + (totalTests - passedTests));
        System.out.println("======================================");
    }

    public static void runTest(String testName, String actual, String expected) {
        totalTests++;
        System.out.println();
        System.out.println("Test Case: " + testName);
        System.out.println("Expected  : " + expected);
        System.out.println("Actual    : " + actual);
        if (actual.equals(expected)) {
            passedTests++;
            System.out.println("Result    : PASS");
        } else {
            System.out.println("Result    : FAIL");
        }
    }

    public static void runPrefixTest(String testName, String actual, String expectedPrefix) {
        totalTests++;
        System.out.println();
        System.out.println("Test Case: " + testName);
        System.out.println("Expected  : starts with \"" + expectedPrefix + "\"");
        System.out.println("Actual    : " + actual);
        if (actual.startsWith(expectedPrefix)) {
            passedTests++;
            System.out.println("Result    : PASS");
        } else {
            System.out.println("Result    : FAIL");
        }
    }
    
}
