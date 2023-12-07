package com.api.api;

import org.springframework.jdbc.core.JdbcTemplate; // Importa la clase JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource; // Importa la clase DriverManagerDataSource

import com.api.api.controllers.LoginController;
import com.api.api.security.SecurityService;
import com.api.api.services.DatabaseService;
import com.api.api.views.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();

        // Configuracion de JdbcTemplate.
        JdbcTemplate jdbcTemplate = configureJdbcTemplate();

        // Creación de Databse Service.
        DatabaseService databaseService = new DatabaseService(jdbcTemplate);

        LoginController loginController = new LoginController(loginView, databaseService);
        SecurityService securityService = new SecurityService(loginController);

        while (!securityService.isAuthenticated()) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            if (securityService.authenticate(username, password)) {
                System.out.println("Inicio de sesión exitoso.");
            } else {
                System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
            }
        }

        // Resto del código después de la autenticación.
    }

    // Configuracion del JdbcTemplate y devuelve una instancia de la misma.
    private static JdbcTemplate configureJdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tuBaseDeDatos");
        dataSource.setUsername("tuUsuario");
        dataSource.setPassword("tuContraseña");

        return new JdbcTemplate(dataSource);
    }
}
