package com.api.api.security;

import com.api.api.User;
import com.api.api.controllers.LoginController;

public class SecurityService {
    private LoginController loginController;

    public SecurityService(LoginController loginController) {
        this.loginController = loginController;
    }

    public boolean authenticate(String username, String password) {
        // Lógica de autenticación.
        User user = loginController.authenticate(username, password);

        if (user != null) {
            loginController.setAuthenticatedUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuthenticated() {
        return loginController.isAuthenticated();
    }
}
