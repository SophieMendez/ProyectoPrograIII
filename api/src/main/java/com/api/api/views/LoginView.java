package com.api.api.views;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner;

    public LoginView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUsername() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        return username;
    }

    public String getPassword() {
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        return password;
    }

    public void showAuthenticationResult(boolean isAuthenticated) {
        if (isAuthenticated) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
        }
    }

    // Método para cerrar el Scanner cuando sea necesario.
    public void closeScanner() {
        scanner.close();
    }
}
