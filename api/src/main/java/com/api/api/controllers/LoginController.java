package com.api.api.controllers;

import com.api.api.User;
import com.api.api.services.DatabaseService;
import com.api.api.views.LoginView;

public class LoginController {
    private User authenticatedUser;
    private LoginView loginView;
    private DatabaseService databaseService;

    public LoginController(LoginView loginView, DatabaseService databaseService) {
        this.loginView = loginView;
        this.databaseService = databaseService;
    }

    public void handleLogin() {
        while (!isAuthenticated()) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            User user = authenticate(username, password);

            if (user != null) {
                loginView.showAuthenticationResult(true);
                setAuthenticatedUser(user);
            } else {
                loginView.showAuthenticationResult(false);
            }
        }

        // Resto del código.
        // Puedes redirigir a otra vista, realizar operaciones adicionales, etc.
        System.out.println("Usuario autenticado: " + authenticatedUser.getUsername());
    }

    public User authenticate(String username, String password) {
        return databaseService.authenticate(username, password);
    }
    
    public void setAuthenticatedUser(User user) {
        authenticatedUser = user;
    }

    public boolean isAuthenticated() {
        return authenticatedUser != null;
    }
    
}
