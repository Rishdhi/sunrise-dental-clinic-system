/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.BillController;
import model.AppointmentDetails;
/**
 *
 * @author Admin
 */
public class BillTestRunner {
    
    static int totalTests = 0;
    static int passedTests = 0;

    public static void main(String[] args) {

        BillController controller = new BillController();

        System.out.println("======================================");
        System.out.println("       AUTOMATED BILLING TESTING");
        System.out.println("======================================");

        AppointmentDetails valid = controller.getAppointmentForBilling("1");
        runObjectTest("Load Existing Appointment (No. 1)", valid, true);

        AppointmentDetails invalidNumber = controller.getAppointmentForBilling("999999");
        runObjectTest("Load Non-Existent Appointment", invalidNumber, false);

        AppointmentDetails nonNumeric = controller.getAppointmentForBilling("abc");
        runObjectTest("Load With Non-Numeric Input", nonNumeric, false);

        AppointmentDetails empty = controller.getAppointmentForBilling("");
        runObjectTest("Load With Empty Input", empty, false);

        runTest(
                "Negative Consultation Fee",
                controller.generateBill(1, "Cleaning", -500),
                "Consultation fee cannot be negative"
        );

        String billResult = controller.generateBill(1, "Cleaning", 500);
        runPrefixTest("Generate Bill Success", billResult, "BILL_SAVED:");

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

    public static void runObjectTest(String testName, Object actual, boolean expectNotNull) {
        totalTests++;
        System.out.println();
        System.out.println("Test Case: " + testName);
        System.out.println("Expected  : " + (expectNotNull ? "not null" : "null"));
        System.out.println("Actual    : " + (actual == null ? "null" : "not null"));
        boolean pass = expectNotNull ? (actual != null) : (actual == null);
        if (pass) {
            passedTests++;
            System.out.println("Result    : PASS");
        } else {
            System.out.println("Result    : FAIL");
        }
    }
    
}
