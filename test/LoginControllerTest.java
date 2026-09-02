/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.LoginController;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoginControllerTest {

    LoginController controller = new LoginController();

    @Test
    public void testValidLogin() {

        String result = controller.login("admin", "12345");

        assertEquals("LOGIN_SUCCESS", result);
    }
    
    //    Test Case 2 – Invalid Password
    @Test
    public void testInvalidPassword() {

        String result =
                controller.login("admin", "wrong123");

        assertEquals(
                "INVALID_CREDENTIALS",
                result
        );
    }
   
  // Test Case 3 – Empty Username
    @Test
    public void testEmptyUsername() {

        String result =
                controller.login("", "12345");

        assertEquals(
                "Username is required",
                result
        );
    }
    
   // Test Case 4 – Empty Password
    @Test
    public void testEmptyPassword() {

        String result =
                controller.login("admin", "");

        assertEquals(
                "Password is required",
                result
        );
    }
    
//    Test Case 5 – Short Username
    @Test
    public void testShortUsername() {

        String result =
                controller.login("ab", "12345");

        assertEquals(
                "Username must contain at least 3 characters",
                result
        );
    }
    
    //    Test 6 – Short Password
    @Test
    public void testShortPassword() {

        String result =
                controller.login("admin", "123");

        assertEquals(
                "Password must contain at least 5 characters",
                result
        );
    }

    //Test 7 – Non-existing User
    @Test
    public void testNonExistingUser() {

        String result =
                controller.login("unknown", "12345");

        assertEquals(
                "INVALID_CREDENTIALS",
                result
        );
    }

    //Test 8 – Another Valid User
    @Test
    public void testStudentLogin() {

        String result =
                controller.login("student", "student123");

        assertEquals(
                "LOGIN_SUCCESS",
                result
        );
    }

}