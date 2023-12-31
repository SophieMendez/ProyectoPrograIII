package com.api.api;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User {
    

    private int UserID;
    private String  Username;
    private String Email;
    private String Password;
    private String JWT;
    private String mySecreString= "unPassword Super Fuerte";

    public User() {
        this.UserID = 0;
        this.Username = "";
        this.Email = "";
        this.Password = "";
    }

    public User(int userID,String username,String email, String password) {
        this.UserID = userID;
        this.Username = username;
        this.Email = email;
        this.Password = password;
        this.JWT = generateJsonWebToken(username, password);
    }
   public User( String username,String email, String password) {
        
        this.Username = username;
        this.Email = email;
        this.Password = password;
        this.JWT = generateJsonWebToken(username, password);
  
    }
    public int getUserID() {
        return this.UserID;
    }

    public String getEmail() {
        return this.Email;
    }

     public boolean checkPassword(String password) {
        return this.Password.equals(password);
    }

    public void setPassword(String password) {
        this.Password = password;
    }   

    public void setJTW() {
        this.JWT = generateJsonWebToken(this.Username, this.Password);
    }  
   
    private String generateJsonWebToken(String username, String password) {
        try {
            
            String dataToHash = ""+username + password + mySecreString;
            System.out.println("jtw = " + username);
     
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));

            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            System.out.println("jtw = " + hexString.toString());
     
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; 
        }
    }
    
}
