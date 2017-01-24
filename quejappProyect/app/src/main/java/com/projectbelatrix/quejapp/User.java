package com.projectbelatrix.quejapp;

/**
 * Created by Elias on 24/01/2017.
 */

public class User {
    int id ;
    String username,password,email;

    public void setId (int id){
        this.id = id ;
    }
    public int getId () {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
