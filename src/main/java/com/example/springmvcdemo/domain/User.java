package com.example.springmvcdemo.domain;


import jakarta.validation.constraints.*;

public class User {
    private String username;
    private String email;
    private String password;

    @NotEmpty(message = "Not empty")
    private String name;

    private String phoneNumber;
    private String country;

    @Min(value=0,message = "Greater than or equal to 0")
    @Max(value=10,message = "Less than or equal to 10")
    private int freePasses;

    public User() {
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
