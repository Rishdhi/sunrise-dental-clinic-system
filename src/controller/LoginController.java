/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.UserDAO;

/**
 *
 * @author hnd
 */
public class LoginController {
    
    private UserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    // Validation method
    public String validateInput(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            return "Username is required";
        }

        if (password == null || password.trim().isEmpty()) {
            return "Password is required";
        }

        if (username.length() < 3) {
            return "Username must contain at least 3 characters";
        }

        if (password.length() < 5) {
            return "Password must contain at least 5 characters";
        }

        return "VALID";
    }

    // Login method
    public String login(String username, String password) {

        String validationResult =
                validateInput(username, password);

        if (!validationResult.equals("VALID")) {
            return validationResult;
        }

        boolean authenticated =
                userDAO.authenticate(username, password);

        if (authenticated) {
            return "LOGIN_SUCCESS";
        }

        return "INVALID_CREDENTIALS";
    }
}
