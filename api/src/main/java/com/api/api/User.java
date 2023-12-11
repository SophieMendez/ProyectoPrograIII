package com.api.api;

import java.io.Serializable;


public class User implements Serializable {

    private final int id;
    private final String username;
    private final String password;

    public User(int id, String username, String password) {
        // Validación de datos (puedes personalizar esto según tus necesidades)
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be null or empty");
        }

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

 
}
