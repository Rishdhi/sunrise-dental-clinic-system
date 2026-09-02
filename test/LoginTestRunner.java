
import controller.LoginController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hnd
 */
public class LoginTestRunner {
    
    static int totalTests = 0;
    static int passedTests = 0;

    public static void main(String[] args) {

        LoginController controller =
                new LoginController();

        System.out.println("======================================");
        System.out.println("       AUTOMATED LOGIN TESTING");
        System.out.println("======================================");

        runTest(
                "Valid Login",
                controller.login("admin", "12345"),
                "LOGIN_SUCCESS"
        );
        
         runTest(
                "Invalid Password",
                controller.login("admin", "wrong123"),
                "INVALID_CREDENTIALS"
        );

        runTest(
                "Empty Username",
                controller.login("", "12345"),
                "Username is required"
        );

        runTest(
                "Empty Password",
                controller.login("admin", ""),
                "Password is required"
        );

        runTest(
                "Short Username",
                controller.login("ab", "12345"),
                "Username must contain at least 3 characters"
        );

        runTest(
                "Short Password",
                controller.login("admin", "123"),
                "Password must contain at least 5 characters"
        );

        runTest(
                "Non Existing User",
                controller.login("unknown", "12345"),
                "INVALID_CREDENTIALS"
        );

        runTest(
                "Valid Student Login",
                controller.login("student", "student123"),
                "LOGIN_SUCCESS"
        );


         System.out.println();
        System.out.println("======================================");
        System.out.println("              SUMMARY");
        System.out.println("======================================");

        System.out.println("Total Tests  : " + totalTests);
        System.out.println("Passed Tests : " + passedTests);
        System.out.println("Failed Tests : "
                + (totalTests - passedTests));

        System.out.println("======================================");
    }
    
    public static void runTest(
            String testName,
            String actual,
            String expected) {

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
}
